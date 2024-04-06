package ui.auth.signup.store

import com.arkivanov.mvikotlin.core.store.Reducer

object SignUpReducer : Reducer<SignUpStore.State, SignUpStore.Message> {

    override fun SignUpStore.State.reduce(msg: SignUpStore.Message): SignUpStore.State {
        return when (msg) {
            else -> {
                copy()
            }
        }
    }

}