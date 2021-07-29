package com.oyoyoy.karma.peopleList


import androidx.lifecycle.MutableLiveData

class PeopleListViewModel  {
    var list = mutableListOf<Person>()
    val peopleList = MutableLiveData<List<Person>>()



    var personAdapter: PeopleListAdapter = PeopleListAdapter(peopleList)
    init {
        ///testCode
        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)

        //peopleList.value = listOf(temp1,temp2,temp3)
        addItem(temp1)
        addItem(temp2)
        addItem(temp3)
        personAdapter.setList(peopleList)
        //Log.d("debugging",peopleList.toString())

    }



    fun addItem(item: Person) {
        list.add(item)
        peopleList.value = list
    }

    fun removeItem(item: Person) {
        list.remove(item)
        peopleList.value = list
    }


}