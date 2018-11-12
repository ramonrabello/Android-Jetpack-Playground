# Android-Jetpack-Playground

Sample app that uses some [Android Jetpack](https://developer.android.com/jetpack/) components and the new [AndroidX](https://developer.android.com/jetpack/androidx/) libraries. It communicates with
the [Star Wars API](https://swapi.co) to load some info about characters.

### Cloning
You can use any Git clients or just type this in command line:

    git clone https://github.com/ramonrabello/Android-Jetpack-Playground.git

# Project Architecture

This project was built using some Android Jetpack components like AndroidX, Lifecycle, LiveData, Material Design just to 
name a few. The new Kotlin 1.3 was used in order to use stable Coroutines as announced during the KotlinConf 2018. The 
project also used the Coroutines Android library in order to use the Dispatchers.Main which dispatches a coroutine 
to be run on main thread. If you want to deep dive into Kotlin Coroutines, I recommend you to go through the
[Kotlin Coroutines Complete Guide](https://kotlinlang.org/docs/reference/coroutines-overview.html).

# Project Modules
The project was built entirely in Kotlin and has two modules:
- __core:__ The common module composed by core classes like data models, networking, coroutines scope.
- __app:__ The app module that is composed by the presentation classes like ViewModel, Activity, Fragment.


# Libraries

The file `buildsystem/dependencies.gradle` contains all the library dependencies used
in the project. It is organized by `region`s according to context like support library,
architecture, UI, network, testing (unit and instrumentation).

## Kotlin
- Kotlin Standard Library
- Coroutines Core
- Coroutines Android

## AndroidX
- AppCompat
- Material
- CardView
- RecyclerView
- Fragment
- ConstraintLayout

## Network
- Gson
- OkHttp
- OkHttp Logging Interceptor
- Retrofit
- Okio
- Retrofit 2 Coroutines Adapter
- Retrofit 2 Converter for Gson

## Architecture
- Architecture Components (Lifecycle Extensions)
## Testing
### Unit Testing
- JUnit
- Android Test Runner
- Android Test Rules
### Instrumentation Tests
- Espresso

# License
    Copyright 2018 Ramon Rabello
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
