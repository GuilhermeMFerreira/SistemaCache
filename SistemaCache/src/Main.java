void main() {

        List<Pessoa> banco = new ArrayList<>();
        List<Pessoa> cache = new ArrayList<>();

        // Banco mockado com mais de 10 pessoas
        banco.add(new Pessoa(1, "Ana Silva", 28));
        banco.add(new Pessoa(2, "Bruno Costa", 34));
        banco.add(new Pessoa(3, "Carla Souza", 22));
        banco.add(new Pessoa(4, "Diego Lima", 45));
        banco.add(new Pessoa(5, "Elena Fernandes", 29));
        banco.add(new Pessoa(6, "Fernando Rocha", 31));
        banco.add(new Pessoa(7, "Gabriela Alves", 26));
        banco.add(new Pessoa(8, "Henrique Martins", 40));
        banco.add(new Pessoa(9, "Isabela Santos", 23));
        banco.add(new Pessoa(10, "João Pereira", 37));
        banco.add(new Pessoa(11, "Karen Oliveira", 30));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite o ID da pessoa para buscar (ou 0 para sair): ");
            int idBuscado = Integer.parseInt(IO.readln());

            if (idBuscado == 0) {
                System.out.println("Acabo o sistema... já trabalhou muito");
                break;
            }

            // 1. Busca direta no cache
            Pessoa pessoaEncontrada = null;
            for (Pessoa p : cache) {
                if (p.getId() == idBuscado) {
                    pessoaEncontrada = p;
                    break;
                }
            }

            if (pessoaEncontrada != null) {
                System.out.println("Pessoa encontrada no cache: " + pessoaEncontrada);
            } else {
                // 2. Busca direta no banco caso não esteja no cache
                for (Pessoa p : banco) {
                    if (p.getId() == idBuscado) {
                        pessoaEncontrada = p;
                        break;
                    }
                }

                if (pessoaEncontrada != null) {
                    // Desafio: Remove a pessoa mais antiga (índice 0) se o cache atingiu o limite
                    int LIMITE_CACHE = 10;
                    if (cache.size() >= LIMITE_CACHE) {
                        Pessoa removida = cache.remove(0);
                    }

                    cache.add(pessoaEncontrada);
                    System.out.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
                } else {
                    System.out.println("Pessoa não encontrada no banco de dados.");
                }
            }
        }
    }

