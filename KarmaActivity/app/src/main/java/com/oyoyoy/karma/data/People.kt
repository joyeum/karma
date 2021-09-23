package com.oyoyoy.karma.data

import android.content.res.Resources
import com.oyoyoy.karma.R

fun personList(resources: Resources):List<Person> {
    return listOf(
        Person(
            id = 1,
            name = resources.getString(R.string.person1_name),
            image = R.drawable.rose,
            description = resources.getString(R.string.person1_description)
        ),
        Person(
            id = 2,
            name = resources.getString(R.string.person2_name),
            image = R.drawable.freesia,
            description = resources.getString(R.string.person2_description)
        ),
        Person(
            id = 3,
            name = resources.getString(R.string.person3_name),
            image = R.drawable.lily,
            description = resources.getString(R.string.person3_description)
        )
        /* ,
        Person(
            id = 4,
            name = resources.getString(R.string.person4_name),
            image = R.drawable.sunflower,
            description = resources.getString(R.string.person4_description)
        ),
        Person(
            id = 5,
            name = resources.getString(R.string.person5_name),
            image = R.drawable.peony,
            description = resources.getString(R.string.person5_description)
        ),
        Person(
            id = 6,
            name = resources.getString(R.string.person6_name),
            image = R.drawable.daisy,
            description = resources.getString(R.string.person6_description)
        ),
        Person(
            id = 7,
            name = resources.getString(R.string.person7_name),
            image = R.drawable.lilac,
            description = resources.getString(R.string.person7_description)
        ),
        Person(
            id = 8,
            name = resources.getString(R.string.person8_name),
            image = R.drawable.marigold,
            description = resources.getString(R.string.person8_description)
        ),
        Person(
            id = 9,
            name = resources.getString(R.string.person9_name),
            image = R.drawable.poppy,
            description = resources.getString(R.string.person9_description)
        ),
        Person(
            id = 10,
            name = resources.getString(R.string.person10_name),
            image = R.drawable.daffodil,
            description = resources.getString(R.string.person10_description)
        ),
        Person(
            id = 11,
            name = resources.getString(R.string.person11_name),
            image = R.drawable.dahlia,
            description = resources.getString(R.string.person11_description)
        )

         */

    )
}