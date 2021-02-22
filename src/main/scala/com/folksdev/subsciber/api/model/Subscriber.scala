package com.folksdev.subsciber.api.model

import com.folksdev.subsciber.api.model.Period.Period
import com.folksdev.subsciber.api.model.Topic.Topic


case class Subscriber(id: Long = 0L, email: String, period: Period, topics: Set[Topic])
