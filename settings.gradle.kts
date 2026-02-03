rootProject.name = "licencjat"

include(
    "app",
    "app:application",
    "app:ports-output",
    "app:entrypoint",
    "app:ports-input",
    "app:infrastructure",
    "app:commons"
)

include("app")
include("app:domain")