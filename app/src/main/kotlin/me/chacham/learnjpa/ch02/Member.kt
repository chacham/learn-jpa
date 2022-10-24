package me.chacham.learnjpa.ch02

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "MEMBER")
data class Member(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "NAME")
        var usernaame: String,
        var age: Int
)