# Tasks



# Pedro:

## Devedor
- Atualizar o valor `devedor` do usuário quando necessário.
- Ao devolver o livro, remover o status de devedor do usuário, se não houver outros empréstimos em atraso.
- Ao devolver, marcar o exemplar como disponível (remover status de empréstimo).
- Após devolução:
  - Identificar o primeiro usuário na fila de reservas.
  - Verificar se ele pode realizar o empréstimo:
    - Se sim, efetuar o empréstimo.
    - Se não, mover o usuário para o final da fila e verificar o próximo.

## Empréstimo
- Remover o status de emprestado do exemplar ao finalizar o empréstimo.



---
# Lucca

## Notificações
- Criar interface para diferentes tipos de notificação para usuários.
- Implementar notificações relacionadas a outras classes (livros)
- Notificações Recebidas -> especifica para o professor (criar uma interface)
