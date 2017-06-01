package com.bkase.cyklic.drivers

import rx.Observable
import rx.Observer
import rx.Subscription

/**
 * Created by bkase on 3/26/16.
 */

interface Driver<Input, Output> {
  val input: Input
  fun output(o: Observable<Output>): Subscription
}

object Drivers {
  fun <T> patch(o: Observable<T>, subj: Observer<T>): Subscription =
      o.subscribe{ subj.onNext(it) }
}

