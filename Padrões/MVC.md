# MVC com Strategy, Observer e Composite

## 7. Strategy + Observer + Composite = MVC Java

### Explicação

O MVC é um padrão arquitetural que separa uma aplicação em três partes principais:

- Model: responsável pelos dados e regras do sistema.
- View: responsável por exibir as informações ao usuário.
- Controller: responsável por controlar as ações do sistema.

Neste exemplo, o MVC foi relacionado com três padrões de projeto:

- Strategy: usado para definir a forma de formatação do texto.
- Observer: usado para avisar a View quando o Model é atualizado.
- Composite: usado para montar uma tela com vários componentes.

Com isso, o sistema fica mais organizado, pois cada parte possui uma responsabilidade específica.

---

## UML

```text
                         STRATEGY
+------------------------------------------------+
|              <<interface>>                     |
|              FormatacaoStrategy                |
+------------------------------------------------+
| + formatar(texto: String): String              |
+------------------------------------------------+
              ▲
              |
        +-----+----------------+
        |                      |
+---------------------+  +---------------------+
| FormatacaoMaiuscula |  | FormatacaoMinuscula |
+---------------------+  +---------------------+
| + formatar(texto:   |  | + formatar(texto:   |
|   String): String   |  |   String): String   |
+---------------------+  +---------------------+


                         OBSERVER
+------------------------------------------------+
|              <<interface>>                     |
|                 Observador                     |
+------------------------------------------------+
| + atualizar(mensagem: String): void            |
+------------------------------------------------+
                         ▲
                         |
+------------------------------------------------+
|                 TarefaView                     |
+------------------------------------------------+
| + atualizar(mensagem: String): void            |
| + mostrar(texto: String): void                 |
+------------------------------------------------+


                         MODEL
+------------------------------------------------+
|                 TarefaModel                    |
+------------------------------------------------+
| - descricao: String                            |
| - observadores: List<Observador>               |
+------------------------------------------------+
| + setDescricao(descricao: String): void        |
| + getDescricao(): String                       |
| + adicionarObservador(observador: Observador): |
|   void                                         |
| + notificar(): void                            |
+------------------------------------------------+
                         |
                         | notifica
                         ▼
+------------------------------------------------+
|                 Observador                     |
+------------------------------------------------+


                       CONTROLLER
+------------------------------------------------+
|              TarefaController                  |
+------------------------------------------------+
| - model: TarefaModel                           |
| - view: TarefaView                             |
| - strategy: FormatacaoStrategy                 |
+------------------------------------------------+
| + alterarTarefa(descricao: String): void       |
+------------------------------------------------+
        |                         |                         |
        | controla                | atualiza                | usa
        ▼                         ▼                         ▼
+---------------+        +---------------+        +----------------------+
| TarefaModel   |        | TarefaView    |        | FormatacaoStrategy   |
+---------------+        +---------------+        +----------------------+


                         COMPOSITE
+------------------------------------------------+
|              <<interface>>                     |
|                ComponenteTela                  |
+------------------------------------------------+
| + renderizar(): void                           |
+------------------------------------------------+
              ▲
              |
        +-----+----------------+
        |                      |
+-------------------+   +------------------------------+
|     TextoTela     |   |          PainelTela          |
+-------------------+   +------------------------------+
| - texto: String   |   | - componentes:               |
+-------------------+   |   List<ComponenteTela>       |
| + renderizar():   |   +------------------------------+
|   void            |   | + adicionar(componente:      |
+-------------------+   |   ComponenteTela): void      |
                        | + renderizar(): void         |
                        +------------------------------+
                                      |
                                      | contém
                                      ▼
                        +------------------------------+
                        |        ComponenteTela        |
                        +------------------------------+
