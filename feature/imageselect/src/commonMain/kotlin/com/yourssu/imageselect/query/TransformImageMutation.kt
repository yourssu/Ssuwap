package com.yourssu.imageselect.query

import com.yourssu.imageselect.api.ImageDataSource
import dev.zacsweers.metro.Inject
import com.yourssu.imageselect.model.TransformImageMutationKey
import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import dev.shreyaspatil.ai.client.generativeai.type.content
import soil.query.MutationId
import soil.query.buildMutationKey
import ssuwap.feature.imageselect.generated.resources.Res

@Inject
class TransformImageMutation(
    private val generativeModel: GenerativeModel,
    private val imageDataSource: ImageDataSource
) : TransformImageMutationKey by buildMutationKey(
    id = MutationId("transform/gemini"),
    mutate = { uri ->
        val imageBytes = imageDataSource.getImageData(uri)
            ?: throw IllegalStateException("Failed to read image data from URI")

        val characterBytes = Res.readBytes("files/ssungssung.webp")

        val response = generativeModel.generateContent(
            content {
                text("3D 렌더링, 슝슝 캐릭터의 디자인을 따름. 몸통은 하얀색 유니콘 모양, 뿔이 있고, 파란색 갈기가 물결치듯 있음. 살구색 코와 작은 눈, 웃는 입을 가진 얼굴. 손과 발은 연한 하늘색. 배에는 살구색 원형 패치가 있음. 단순한 디자인, 부드러운 플라스틱 질감, 즐거운 표정")
                image(imageBytes)
                text("이 이미지의 인물을 다음 캐릭터로 바꿔줘")
                image(characterBytes)
            }
        )
        response.text ?: "None"
    }
)