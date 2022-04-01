package com.zcdev.tpnote.entities

class Item {
    var id:Int?=null
    var nom: String? = null
    var desc: String? = null
    var image:Int=0
    constructor(){

    }
    constructor(id:Int,n:String,d:String){
        this.id=id
        this.nom=n
        this.desc=d
    }
    constructor(id:Int,n:String,d:String,image:Int){
        this.id=id
        this.nom=n
        this.desc=d
        this.image=image
    }

}