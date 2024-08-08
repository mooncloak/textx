# textx

kotlinx.serialization models for representing rich text content. This makes it easier for different platforms, in
particular mobile platforms, to render rich text using their native UI framework without complex format-specific
parsers. For instance, instead of the server providing an HTML text string through an API, requiring the client to use
a WebView component to render it, the server can return these pre-parsed serialization models, which can easily be
transformed into native UI components for each platform.

<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/textx">


## Status ⚠️

> [!Warning]
> This project is being actively developed but is in an early experimental state. Use the library
> cautiously and report back any issues. mooncloak is not responsible for any issues faced when
> using
> the library.

## Getting Started 🏁

Checkout the [releases page](https://github.com/mooncloak/textx/releases) to get the latest version.
<br/><br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/mooncloak/textx">

### Repository

```kotlin
repositories {
    maven("https://repo.repsy.io/mvn/mooncloak/public")
}
```

### Dependencies

```kotlin
implementation("com.mooncloak.kodetools.textx:textx-core:VERSION")
```

## Documentation 📃

More detailed documentation is available in the [docs](docs/) folder. The entry point to the
documentation can be
found [here](docs/index.md).

## Security 🛡️

For security vulnerabilities, concerns, or issues, please refer to
the [security policy](SECURITY.md) for more
information on appropriate approaches for disclosure.

## Contributing ✍️

Outside contributions are welcome for this project. Please follow
the [code of conduct](CODE_OF_CONDUCT.md)
and [coding conventions](CODING_CONVENTIONS.md) when contributing. If contributing code, please add
thorough documents
and tests. Thank you!

## License ⚖️

```
Copyright 2024 mooncloak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
