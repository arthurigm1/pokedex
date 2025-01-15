# Pokedex Android - Kotlin

Este é um aplicativo Android simples desenvolvido em Kotlin, que consome uma API pública de Pokémon e exibe os resultados em uma interface gráfica. O aplicativo utiliza Retrofit para fazer a requisição à API e Glide para exibir as imagens dos Pokémon. A lista de Pokémon é mostrada em um `RecyclerView`, e ao clicar em um Pokémon, a tela de detalhes exibe o nome do Pokémon selecionado.

## Funcionalidades

- **Consumir API de Pokémon**: O app consome a API pública que retorna dados sobre os Pokémon.
- **Exibição em RecyclerView**: Os Pokémon são listados em um `RecyclerView` com nome e imagem.
- **Interface simples e limpa**: A interface é simples e fácil de navegar, com foco na exibição de informações.
- **Detalhes do Pokémon**: Ao clicar em um item da lista, o app abre uma nova tela com o nome do Pokémon selecionado.

## Arquitetura

- **Kotlin**: Linguagem utilizada para desenvolvimento Android.
- **Retrofit**: Biblioteca para consumo de APIs RESTful.
- **Glide**: Biblioteca para carregamento de imagens.
- **RecyclerView**: Componente utilizado para exibir a lista de Pokémon.
- **Intent**: Para navegação entre a tela principal e a tela de detalhes.

## Tecnologias Utilizadas

- **Android SDK**: Ferramentas para desenvolvimento de aplicativos Android.
- **Retrofit2**: Biblioteca para realizar chamadas HTTP e mapear a resposta JSON para objetos Kotlin.
- **Glide**: Biblioteca para carregamento e exibição de imagens de forma eficiente.
- **RecyclerView**: Componente para exibição de listas de itens de forma otimizada.
- **Kotlin Coroutines** (caso seja necessário para requisições assíncronas, se aplicável).

## Como Executar o Projeto

### Pré-requisitos

1. **Android Studio** instalado.
2. **JDK 8 ou superior** instalado.
3. **Conexão com a Internet** para consumir a API de Pokémon.

### Passos para Execução

1. Clone o repositório:

```bash
git clone https://github.com/arthurigm1/pokedex.git
