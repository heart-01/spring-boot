package com.example.demo.controllers

import com.example.demo.models.SampleData
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sample")
class sampleController {
    // GET: http://localhost:8080/api/sample/hello
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, World!1"
    }

    // GET: http://localhost:8080/api/sample
    @GetMapping
    fun getSample(): List<SampleData> {
        return listOf(
            SampleData(1, "John Doe", "admin@email.com", "0812345678", "Bangkok"),
            SampleData(2, "John Doe", "admin@email.com", "0812345678", "Bangkok"),
            SampleData(3, "John Doe", "admin@email.com", "0812345678", "Bangkok"),
        )
    }

    // GET: http://localhost:8080/api/sample/1
    @GetMapping("/{id}")
    fun getSampleById(@PathVariable id: Int): SampleData {
        return SampleData(id, "John Doe", "admin@email.com", "0812345678", "Bangkok")
    }

    // POST: http://localhost:8080/api/sample
    @PostMapping
    fun createSample(@RequestBody data: SampleData): SampleData {
        return data
    }

    // Put: http://localhost:8080/api/sample/1
    @PutMapping("/{id}")
    fun updateSample(@PathVariable id: Int, @RequestBody data: SampleData): SampleData {
        return data.copy(id = id)
    }

    // Delete: http://localhost:8080/api/sample/1
    @DeleteMapping("/{id}")
    fun deleteSample(@PathVariable id: Int): String {
        return "Sample ID $id has been deleted"
    }
}