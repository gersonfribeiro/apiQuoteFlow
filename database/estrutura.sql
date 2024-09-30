create table public.categorias (
                                   id_categoria uuid primary key not null,
                                   categoria character varying(255)
);

create table public.cotacoes (
                                 id_cotacao uuid primary key not null,
                                 categoria character varying(255),
                                 data_solicitacao timestamp(6) without time zone,
                                 status character varying(255),
                                 id_autor uuid not null,
                                 foreign key (id_autor) references public.usuarios (id_usuario)
                                     match simple on update no action on delete no action
);

create table public.cotacoes_respondidas (
                                             id_cotacao_respondida uuid primary key not null,
                                             id_solicitacao uuid not null,
                                             id_usuario uuid not null,
                                             foreign key (id_usuario) references public.usuarios (id_usuario)
                                                 match simple on update no action on delete no action,
                                             foreign key (id_solicitacao) references public.cotacoes (id_cotacao)
                                                 match simple on update no action on delete no action
);

create table public.destinatarios (
                                      id_resposta uuid primary key not null,
                                      id_fornecedor uuid not null,
                                      id_solicitacao uuid not null,
                                      foreign key (id_solicitacao) references public.cotacoes (id_cotacao)
                                          match simple on update no action on delete no action,
                                      foreign key (id_fornecedor) references public.empresas (id_empresa)
                                          match simple on update no action on delete no action
);

create table public.empresas (
                                 id_empresa uuid primary key not null,
                                 cnpj character varying(20) not null,
                                 nome_fantasia character varying(50),
                                 nome_empresa character varying(100)
);

create table public.enderecos (
                                  id_endereco uuid primary key not null,
                                  bairro character varying(255) not null,
                                  cep character varying(255) not null,
                                  complemento character varying(255) not null,
                                  localidade character varying(255) not null,
                                  logradouro character varying(255) not null,
                                  numero character varying(255) not null,
                                  uf character varying(255) not null,
                                  id_usuario uuid not null,
                                  foreign key (id_usuario) references public.usuarios (id_usuario)
                                      match simple on update no action on delete no action
);

create table public.fornecedor (
                                   id_fornecedor uuid primary key not null,
                                   data_registro timestamp(6) without time zone,
                                   id_usuario uuid not null,
                                   foreign key (id_usuario) references public.usuarios (id_usuario)
                                       match simple on update no action on delete no action
);

create table public.fornecedor_categoria (
                                             fornecedor_id uuid not null,
                                             categoria_id uuid not null,
                                             primary key (fornecedor_id, categoria_id),
                                             foreign key (categoria_id) references public.categorias (id_categoria)
                                                 match simple on update no action on delete no action,
                                             foreign key (fornecedor_id) references public.fornecedor (id_fornecedor)
                                                 match simple on update no action on delete no action
);

create table public.fornecedores (
                                     id_fornecedor uuid primary key not null,
                                     id_solicitacao uuid not null,
                                     id_usuario uuid not null,
                                     foreign key (id_usuario) references public.usuarios (id_usuario)
                                         match simple on update no action on delete no action,
                                     foreign key (id_solicitacao) references public.cotacoes (id_cotacao)
                                         match simple on update no action on delete no action
);

create table public.imagens (
                                id_imagem uuid primary key not null,
                                url_imagem character varying(255),
                                id_usuario uuid not null,
                                foreign key (id_usuario) references public.usuarios (id_usuario)
                                    match simple on update no action on delete no action
);

create table public.itens (
                              item_id uuid primary key not null,
                              descricao character varying(50) not null,
                              observacoes character varying(255) not null,
                              quantidade integer not null,
                              id_cotacao uuid,
                              foreign key (id_cotacao) references public.cotacoes (id_cotacao)
                                  match simple on update no action on delete no action
);

create table public.produtos (
                                 id_produto uuid primary key not null,
                                 descricao_produto character varying(255)
);

create table public.respostas_itens (
                                        id_resposta uuid primary key not null,
                                        observacoes character varying(255),
                                        preco_oferecido double precision not null,
                                        id_item_cotacao uuid not null,
                                        id_resposta_cotacao uuid not null,
                                        foreign key (id_resposta_cotacao) references public.cotacoes_respondidas (id_cotacao_respondida)
                                            match simple on update no action on delete no action,
                                        foreign key (id_item_cotacao) references public.itens (item_id)
                                            match simple on update no action on delete no action
);
create unique index ukwu2ax7nklow8pqjp1ffea1qd on respostas_itens using btree (id_item_cotacao);

create table public.telefones (
                                  id_telefone uuid primary key not null,
                                  telefone character varying(20),
                                  id_usuario uuid not null,
                                  foreign key (id_usuario) references public.usuarios (id_usuario)
                                      match simple on update no action on delete no action
);

create table public.usuarios (
                                 id_usuario uuid primary key not null,
                                 cnpj character varying(255),
                                 email character varying(70) not null,
                                 nome_empresa character varying(255),
                                 nome_fantasia character varying(255),
                                 senha_criptografada character varying(255),
                                 nome_usuario character varying(50)
);
create unique index ukkfsp0s1tflm1cwlj8idhqsad0 on usuarios using btree (email);

