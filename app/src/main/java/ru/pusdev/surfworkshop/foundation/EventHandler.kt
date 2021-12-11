package ru.pusdev.surfworkshop.foundation

interface EventHandler<T> {
    fun obtainEvent(event: T)
}