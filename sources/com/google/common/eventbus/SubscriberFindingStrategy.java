package com.google.common.eventbus;

import com.google.common.collect.Multimap;

interface SubscriberFindingStrategy {
    Multimap<Class<?>, Object> findAllSubscribers(Object obj);
}
