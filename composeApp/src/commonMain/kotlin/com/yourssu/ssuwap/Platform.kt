package com.yourssu.ssuwap

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform