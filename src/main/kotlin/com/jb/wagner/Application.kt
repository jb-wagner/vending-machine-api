package com.jb.wagner

import com.fasterxml.jackson.annotation.JsonInclude
import com.jb.wagner.controllers.PaymentController
import com.jb.wagner.models.*
import io.javalin.ApiBuilder.*
import io.javalin.Javalin
import io.javalin.translator.json.JavalinJacksonPlugin
import com.fasterxml.jackson.module.kotlin.*


class Application {
    companion object {
        private val machine = Machine(
            inventory = listOf(
                StockItem(
                        Product("5477500",
                                "B00ZV9RDKK",
                                "Amazon - Fire TV Stick with Alexa Voice Remote - Black",
                                "Get access to a world of instant entertainment with this product. Just connect to the Internet and stream movies, listen to music, and access a wide variety of other content.",
                                Price(3999, USD)
                        ),
                        9
                ),
                StockItem(
                        Product("5947832",
                                "3800R",
                                "Roku - Streaming Stick - Black",
                                "The Roku Streaming Stick provides access to 500,000+ movies and TV shows for hours of endless entertainment.",
                                Price(4999, USD)
                        ),
                        12
                ),
                StockItem(
                        Product("5577842",
                                "MNN02LL/A",
                                "Beats by Dr. Dre - Powerbeats³ Wireless - Shock Yellow",
                                "Take your workout to the next level with Powerbeats³ Wireless earphones, featuring up to 12 hours of battery life to last through multiple workouts and secure-fit earhooks to maximize comfort and stability.",
                                Price(19999, USD)
                        ),
                        11
                )
            )
        )

        @JvmStatic
        fun main(args: Array<String>) {
            var port = 8080
            if(System.getenv("PORT") != null)
                port = Integer.parseInt(System.getenv("PORT"))

            JavalinJacksonPlugin.configure(jacksonObjectMapper().apply {
                setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY)
            })
            val app = Javalin.start(port)

            val paymentController = PaymentController(machine)
            app.routes {
                path("/inventory") {
                    get("/") { ctx -> ctx.json(machine.inventory) }
                }

                path("/payment") {
                    get("/", paymentController::getPayment)
                    post("/", paymentController::addPayment)
                    delete("/", paymentController::refundPayment)
                }
            }
        }
    }

}