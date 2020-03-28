package com.example.sberify.adapters

class Section(private val firstPosition: Int, name: String) {
    private val sections = ArrayList<MutableList<Any>>()

    fun sections(): MutableList<MutableList<Any>> = sections

    fun <T> sectionItems(section: Int): MutableList<Any> = sections[section]

    fun <T> addSection(section: List<T>) {
        sections().add(ArrayList<Any>(section))
    }

    fun addItemOnSection(section: Int, item: Any) {
        sections()[section].add(item)
    }

    fun <T> addItemListOnSection(section: Int, items: List<T>) {
        sections()[section].addAll(ArrayList<Any>(items))
    }

    fun sectionCount(section: Int): Int =
        if (section > sections().size - 1) 0 else sections()[section].size

}

