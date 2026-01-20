package com.yourssu.imageselect.query

import com.yourssu.imageselect.api.ImageDataSource
import com.yourssu.imageselect.api.ImageStorage
import dev.zacsweers.metro.Inject
import com.yourssu.imageselect.model.TransformImageMutationKey
import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import dev.shreyaspatil.ai.client.generativeai.type.content
import dev.shreyaspatil.ai.client.generativeai.type.BlobPart
import soil.query.MutationId
import soil.query.buildMutationKey
import ssuwap.feature.imageselect.generated.resources.Res

@Inject
class TransformImageMutation(
    private val generativeModel: GenerativeModel,
    private val imageDataSource: ImageDataSource,
    private val imageStorage: ImageStorage
) : TransformImageMutationKey by buildMutationKey(
    id = MutationId("transform/gemini"),
    mutate = { uri ->

        val userImageBytes = imageDataSource.getImageData(uri)
            ?: throw IllegalStateException("Failed to read image data")

        val characterBytes = Res.readBytes("files/ssungssung.webp")

        val response = generativeModel.generateContent(
            content {
                text("""
                    Change the person in the first image into the character shown in the second image.
                    
                    Target Character (Ssung-Ssung):
                    - White unicorn-like body, wavy blue mane, small horn.
                    - Apricot snout, circular belly patch.
                    - Light blue hands and feet.
                    - Smooth plastic texture, 3D render style.
                    
                    Instruction:
                    - Keep the pose, composition, and background of the FIRST image exactly the same.
                    - Only replace the person with the 'Ssung-Ssung' character.
                    - High quality, photorealistic rendering.
                """.trimIndent())

                image(userImageBytes)

                image(characterBytes)
            }
        )
        val imagePart = response.candidates.firstOrNull()?.content?.parts?.find { part ->
            part is BlobPart
        } as? BlobPart

        if (imagePart != null) {
            val savedUri = imageStorage.saveImage(imagePart.blob)
            savedUri
        } else {
            throw RuntimeException("이미지 생성 실패: ${response.text}")
        }
    }
)