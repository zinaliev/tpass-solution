package com.genesys.tpass.passwords

import com.genesys.tpass.passwords.models.UserInfo
import com.google.common.collect.Maps
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class PasswordServiceTest {

    private val users = Maps.newConcurrentMap<String, UserInfo>()
    private val service = PasswordService(users)

    @Before
    fun beforeTest(){
        users.clear()
    }

    @Test
    fun testCreatePasswordOnNonExistingUserGeneratesNewInfo(){
        assertEquals(0, users.size)

        service.createPassword("Alice", 1)

        assertEquals(1, users.size)
    }

    @Test
    fun testCreatePasswordReturnedValueMatchesUserInfoPassword(){
        val pass = service.createPassword("Alice", 1)

        assertEquals(users.get("Alice")?.password, pass)
    }

    @Test
    fun testCreatePasswordCalledTwiceForSameUserOverwritesPassword(){
        val passInitial = service.createPassword("Alice", 1)
        val passUpdated = service.createPassword("Alice", 1)

        assertNotEquals(passInitial, passUpdated)
    }

    @Test
    fun testVerifyPasswordOnNonExistingUserReturnsFalse(){
        assertFalse(service.verifyPassword("Alice", "secret"))
    }


    @Test
    fun testVerifyPasswordOnWrongValueReturnsFalse(){
        val pass = service.createPassword("Alice", 1)

        assertFalse(service.verifyPassword("Alice", "modified $pass"))
    }


    @Test
    fun testVerifyPasswordOnValidPasswordReturnsTrue(){
        val pass = service.createPassword("Alice", 1)
        assertTrue(service.verifyPassword("Alice", pass))
    }

}