package ru.jcm.jcm.controllers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * Test for Businnes Card Controller
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootApplication
@WebAppConfiguration
class BCardControllerTest {
    @Autowired
    lateinit var webApplicationContext: WebApplicationContext
    lateinit var mocMvc: MockMvc

    @Before
    fun init() {
        mocMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()
    }

    private val GET_BCARDS = "/getAllCardsForThisLocation"
    private val GETTING_BC: Int = 320
    private val HEADER_NAME = "Locaton"
    private val HEADER_VALUE = ""

    @Test
    fun controllerMustGetBCardInLocation() {
        mocMvc.perform(MockMvcRequestBuilders.get(GET_BCARDS))
                .andExpect(status().`is`(GETTING_BC))
                        .andExpect(header().string(HEADER_NAME, HEADER_VALUE))
    }
}