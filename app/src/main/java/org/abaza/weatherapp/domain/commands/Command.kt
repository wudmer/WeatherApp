package org.abaza.weatherapp.domain.commands

interface Command<T> {
    fun execute(): T
}