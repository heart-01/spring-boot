package org.example.addressservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class AddressServiceApplication

fun main(args: Array<String>) {
    runApplication<AddressServiceApplication>(*args)
}
