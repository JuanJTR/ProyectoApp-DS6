package com.example.applicationgastos

import  androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {

    @PrimaryKey(autoGenerate = true)
    var userID:Int = 0
    var user: String?
    var name: String?
    var password: String?
    var salary: Double?
    constructor(user: String, name: String, password: String, salary: Double){
        this.user = user
        this.name =  name
        this.password = password
        this.salary = salary
    }
}