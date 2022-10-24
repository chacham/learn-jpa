package me.chacham.learnjpa.ch02

import org.h2.tools.Server
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import javax.persistence.EntityManager
import javax.persistence.Persistence
import kotlin.test.Test

class Ch02Test {
    companion object {
        private val server: Server = Server.createTcpServer()

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            server.start()
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            server.stop()
        }
    }

    @Test
    fun test() {
        val emf = Persistence.createEntityManagerFactory("learn-jpa")
        val em = emf.createEntityManager()
        val tx = em.transaction

        try {
            tx.begin()
            logic(em)
            tx.commit()
        } catch (e: java.lang.Exception) {
            println("Exception!: $e")
            tx.rollback()
        } finally {
            em.close()
        }
        emf.close()
    }

    fun logic(em: EntityManager) {
        val member1 = Member("1", "aa", 29)
        em.persist(member1)
        val member2 = Member("2", "bb", 28)
        em.persist(member2)
        member1.age = 30

        val foundMember1 = em.find(Member::class.java, "1")
        println("Found: $foundMember1")

        val foundMembers = em.createQuery("select m from Member m", Member::class.java).resultList
        println("FoundMembers: $foundMembers")

        em.remove(member1)
        em.remove(member2)
    }
}