package ru.altmanea.edu.ktor.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.altmanea.edu.ktor.model.Config.Companion.serverDomain
import ru.altmanea.edu.ktor.model.Config.Companion.serverPort
import ru.altmanea.edu.ktor.server.face.index
import ru.altmanea.edu.ktor.server.rest.lesson
import ru.altmanea.edu.ktor.server.rest.student

fun main() {
    embeddedServer(
        Netty,
        port = serverPort,
        host = serverDomain,
        watchPaths = listOf("classes", "resources")
    ) {
        main()
    }.start(wait = true)
}

fun Application.main() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        index()
        student()
        lesson()
    }
}