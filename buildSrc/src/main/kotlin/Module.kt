@file:Suppress("ConstPropertyName")

object Module {
    object Features {
        private const val featurePath = ":features"
        object Auth {
            private const val authPath = "$featurePath:auth"
            const val data = "$authPath:data"
            const val domain = "$authPath:domain"
            const val presentation = "$authPath:presentation"
            const val ui = "$authPath:ui"
        }
    }

    const val app = ":app"
    const val core = ":core"
    const val utils = ":utils"
    const val utilsUI = ":utils-ui"
}