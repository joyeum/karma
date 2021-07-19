package com.oyoyoy.karma.peopleList


import androidx.lifecycle.MutableLiveData
import com.oyoyoy.karma.base.BaseViewModel
import com.oyoyoy.karma.peopleList.test.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleListViewModel : BaseViewModel()  {
    var list = mutableListOf<Person>()
    val peopleListData = MutableLiveData<List<Person>>()

    var personAdapter: PeopleListAdapter = PeopleListAdapter(peopleListData)

    override fun onCreate() {
        super.onCreate()
        var temp1 = Person("one","test1",11111)
        var temp2 = Person("two","test2",22222)
        var temp3 = Person("three","test3",33333)

        //peopleList.value = listOf(temp1,temp2,temp3)
        addItem(temp1)
        addItem(temp2)
        addItem(temp3)
        personAdapter.setList(peopleListData)
        //Log.d("debugging",peopleList.toString())
        CoroutineScope(Dispatchers.Main).launch {

        }
    }




    fun addItem(item: Person) {
        list.add(item)
        peopleListData.value = list
    }

    fun removeItem(item: Person) {
        list.remove(item)
        peopleListData.value = list
    }


}