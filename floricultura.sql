--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-09-17 16:32:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 33282)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id_categoria integer NOT NULL,
    nome character varying(30) NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33309)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id_cliente integer NOT NULL,
    nome character varying(30) NOT NULL,
    sobrenome character varying(30) NOT NULL,
    telefone character varying(15) NOT NULL,
    email character varying(50) NOT NULL,
    cpf character(11) NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33308)
-- Name: clientes_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.clientes_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 220
-- Name: clientes_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_cliente_seq OWNED BY public.clientes.id_cliente;


--
-- TOC entry 219 (class 1259 OID 33302)
-- Name: fornecedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedores (
    id_fornecedor integer NOT NULL,
    nome character varying(30) NOT NULL,
    rua character varying(30) NOT NULL,
    numero integer NOT NULL,
    bairro character varying(30) NOT NULL,
    cidade character varying(30) NOT NULL,
    estado character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    telefone character varying(15) NOT NULL
);


ALTER TABLE public.fornecedores OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33301)
-- Name: fornecedores_id_fornecedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fornecedores_id_fornecedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.fornecedores_id_fornecedor_seq OWNER TO postgres;

--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 218
-- Name: fornecedores_id_fornecedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fornecedores_id_fornecedor_seq OWNED BY public.fornecedores.id_fornecedor;


--
-- TOC entry 226 (class 1259 OID 33359)
-- Name: fornecedoresprodutos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedoresprodutos (
    id_fornecedor integer NOT NULL,
    id_produto integer NOT NULL
);


ALTER TABLE public.fornecedoresprodutos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 33328)
-- Name: itensdavenda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itensdavenda (
    id_itemdavenda integer NOT NULL,
    id_venda integer NOT NULL,
    id_produto integer NOT NULL,
    quantidade integer NOT NULL
);


ALTER TABLE public.itensdavenda OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33327)
-- Name: itensdavenda_id_itemdavenda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.itensdavenda_id_itemdavenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.itensdavenda_id_itemdavenda_seq OWNER TO postgres;

--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 224
-- Name: itensdavenda_id_itemdavenda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.itensdavenda_id_itemdavenda_seq OWNED BY public.itensdavenda.id_itemdavenda;


--
-- TOC entry 217 (class 1259 OID 33290)
-- Name: produtos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produtos (
    id_produto integer NOT NULL,
    descricao character varying(30) NOT NULL,
    preco_unitario double precision NOT NULL,
    qtd_estoque integer NOT NULL,
    id_categoria integer NOT NULL
);


ALTER TABLE public.produtos OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 33289)
-- Name: produtos_id_produto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produtos_id_produto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.produtos_id_produto_seq OWNER TO postgres;

--
-- TOC entry 4906 (class 0 OID 0)
-- Dependencies: 216
-- Name: produtos_id_produto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produtos_id_produto_seq OWNED BY public.produtos.id_produto;


--
-- TOC entry 223 (class 1259 OID 33316)
-- Name: vendas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendas (
    id_venda integer NOT NULL,
    total numeric(5,2) NOT NULL,
    data date NOT NULL,
    id_cliente integer NOT NULL
);


ALTER TABLE public.vendas OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33315)
-- Name: vendas_id_venda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vendas_id_venda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vendas_id_venda_seq OWNER TO postgres;

--
-- TOC entry 4907 (class 0 OID 0)
-- Dependencies: 222
-- Name: vendas_id_venda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vendas_id_venda_seq OWNED BY public.vendas.id_venda;


--
-- TOC entry 4718 (class 2604 OID 33312)
-- Name: clientes id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id_cliente SET DEFAULT nextval('public.clientes_id_cliente_seq'::regclass);


--
-- TOC entry 4717 (class 2604 OID 33305)
-- Name: fornecedores id_fornecedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores ALTER COLUMN id_fornecedor SET DEFAULT nextval('public.fornecedores_id_fornecedor_seq'::regclass);


--
-- TOC entry 4720 (class 2604 OID 33331)
-- Name: itensdavenda id_itemdavenda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itensdavenda ALTER COLUMN id_itemdavenda SET DEFAULT nextval('public.itensdavenda_id_itemdavenda_seq'::regclass);


--
-- TOC entry 4716 (class 2604 OID 33293)
-- Name: produtos id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos ALTER COLUMN id_produto SET DEFAULT nextval('public.produtos_id_produto_seq'::regclass);


--
-- TOC entry 4719 (class 2604 OID 33319)
-- Name: vendas id_venda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendas ALTER COLUMN id_venda SET DEFAULT nextval('public.vendas_id_venda_seq'::regclass);


--
-- TOC entry 4886 (class 0 OID 33282)
-- Dependencies: 215
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id_categoria, nome) FROM stdin;
1	Vaso
2	Adubo
3	Flores
4	Sementes
5	Ferramentas
6	Substrato
\.


--
-- TOC entry 4892 (class 0 OID 33309)
-- Dependencies: 221
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id_cliente, nome, sobrenome, telefone, email, cpf) FROM stdin;
1	Ana Carolina	Souza	(47) 91234-5678	ana.souza@gmail.com	12345678900
2	Bruno Henrique	Lima	(47) 99876-5432	bruno.lima@yahoo.com	23456789011
3	Camila Fernandes	Oliveira	(47) 98765-4321	camila.fernandes@outlook.com	34567890122
4	Diego Rafael	Pereira	(47) 97654-3210	diego.pereira@hotmail.com	45678901233
5	Eliana Beatriz	Santos	(47) 96543-2109	eliana.santos@uol.com.br	56789012344
6	Felipe Augusto	Almeida	(47) 95432-1098	felipe.almeida@gmail.com	67890123455
7	Gabriela	Costa Silva	(47) 94321-0987	gabriela.silva@yahoo.com	78901234566
8	Henrique Matheus	Ribeiro	(47) 93210-9876	henrique.ribeiro@outlook.com	89012345677
9	Isabela Mariana	Rocha	(47) 92109-8765	isabela.rocha@hotmail.com	90123456788
10	João Pedro	Azevedo	(47) 91098-7654	joao.azevedo@uol.com.br	12345678999
\.


--
-- TOC entry 4890 (class 0 OID 33302)
-- Dependencies: 219
-- Data for Name: fornecedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedores (id_fornecedor, nome, rua, numero, bairro, cidade, estado, email, telefone) FROM stdin;
1	VasoArte	Rua das Cerâmicas	101	Bairro Industrial	Joinville	Santa Catarina	arteemvasos@vasoarte.com.br	(47) 99874-3210
2	Flores do Campo	Avenida das Flores	567	Bairro Jardim	Blumenau	Santa Catarina	florida@floresdocampo.com.br	(47) 99876-1234
3	AgroVerde	Estrada do Agricultor	88	Zona Rural	São José	Santa Catarina	nutricao@agroverde.com.br	(48) 99988-7766
4	Jardim & Cia	Rua das Ferramentas	432	Bairro Oficina	Florianópolis	Santa Catarina	 verdecomvoce@jardimecia.com.br	(48) 91234-5678
5	TerraFértil	Avenida do Solo	321	 Bairro Campo Verde	Joinville	Santa Catarina	crescimento@terraferil.com.br	(47) 98765-4321
\.


--
-- TOC entry 4897 (class 0 OID 33359)
-- Dependencies: 226
-- Data for Name: fornecedoresprodutos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedoresprodutos (id_fornecedor, id_produto) FROM stdin;
1	110
1	111
1	112
1	113
2	330
2	331
2	332
2	333
3	220
3	221
3	222
3	223
4	550
4	551
4	552
4	553
5	660
5	661
5	662
5	663
\.


--
-- TOC entry 4896 (class 0 OID 33328)
-- Dependencies: 225
-- Data for Name: itensdavenda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itensdavenda (id_itemdavenda, id_venda, id_produto, quantidade) FROM stdin;
1	5	551	2
2	5	660	5
3	5	663	2
4	3	553	1
5	3	552	1
6	3	550	1
7	3	332	1
8	9	111	2
9	9	110	1
10	1	111	5
11	1	330	5
12	1	333	2
13	10	441	40
14	8	662	6
15	8	661	1
16	8	331	20
17	8	551	1
18	8	553	1
19	2	442	5
20	6	443	10
21	7	112	2
22	7	223	3
23	7	220	1
24	4	110	3
25	4	113	1
26	4	440	10
27	4	221	3
\.


--
-- TOC entry 4888 (class 0 OID 33290)
-- Dependencies: 217
-- Data for Name: produtos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produtos (id_produto, descricao, preco_unitario, qtd_estoque, id_categoria) FROM stdin;
110	Vaso de vidro	30	25	1
111	Vaso de plástico	10	150	1
112	Vaso de cerâmica	20	40	1
113	Vaso de madeira	20	30	1
220	Adubo orgânico	15	60	2
221	Fertilizante químico	25	80	2
222	Adubo Líquido	18	50	2
223	Compostagem	12	70	2
330	Flores de corte	5	200	3
331	Flores de jardim	12	100	3
332	Flores perenes	15	80	3
333	Flores anuais	10	120	3
440	Sementes de flores	8	300	4
441	Sementes de hortaliças	5	250	4
442	Sementes de árvores	12	150	4
443	Sementes de grãos	6	200	4
550	Tesouras de poda	25	50	5
551	Enxadas	35	40	5
552	Regadores	20	60	5
553	Luvas de jardinagem	10	100	5
660	Substrato de plantas	15	80	6
661	Terra vegetal	8	120	6
662	Areia	20	50	6
663	Argila expandida	12	70	6
\.


--
-- TOC entry 4894 (class 0 OID 33316)
-- Dependencies: 223
-- Data for Name: vendas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendas (id_venda, total, data, id_cliente) FROM stdin;
1	95.00	2023-04-20	4
2	60.00	2022-10-22	2
3	70.00	2024-08-05	10
4	265.00	2024-06-07	9
5	169.00	2024-03-10	7
6	60.00	2024-07-12	1
7	91.00	2023-08-15	3
8	413.00	2022-06-18	5
9	50.00	2024-08-20	8
10	200.00	2024-09-22	6
\.


--
-- TOC entry 4908 (class 0 OID 0)
-- Dependencies: 220
-- Name: clientes_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_cliente_seq', 1, false);


--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 218
-- Name: fornecedores_id_fornecedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fornecedores_id_fornecedor_seq', 1, false);


--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 224
-- Name: itensdavenda_id_itemdavenda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.itensdavenda_id_itemdavenda_seq', 27, true);


--
-- TOC entry 4911 (class 0 OID 0)
-- Dependencies: 216
-- Name: produtos_id_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produtos_id_produto_seq', 1, false);


--
-- TOC entry 4912 (class 0 OID 0)
-- Dependencies: 222
-- Name: vendas_id_venda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vendas_id_venda_seq', 1, false);


--
-- TOC entry 4722 (class 2606 OID 33288)
-- Name: categoria categoria_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_nome_key UNIQUE (nome);


--
-- TOC entry 4724 (class 2606 OID 33286)
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);


--
-- TOC entry 4730 (class 2606 OID 33314)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 4728 (class 2606 OID 33307)
-- Name: fornecedores fornecedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores
    ADD CONSTRAINT fornecedores_pkey PRIMARY KEY (id_fornecedor);


--
-- TOC entry 4736 (class 2606 OID 33363)
-- Name: fornecedoresprodutos fornecedoresprodutos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedoresprodutos
    ADD CONSTRAINT fornecedoresprodutos_pkey PRIMARY KEY (id_fornecedor, id_produto);


--
-- TOC entry 4734 (class 2606 OID 33333)
-- Name: itensdavenda itensdavenda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itensdavenda
    ADD CONSTRAINT itensdavenda_pkey PRIMARY KEY (id_itemdavenda);


--
-- TOC entry 4726 (class 2606 OID 33295)
-- Name: produtos produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (id_produto);


--
-- TOC entry 4732 (class 2606 OID 33321)
-- Name: vendas vendas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_pkey PRIMARY KEY (id_venda);


--
-- TOC entry 4741 (class 2606 OID 33364)
-- Name: fornecedoresprodutos fornecedoresprodutos_id_fornecedor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedoresprodutos
    ADD CONSTRAINT fornecedoresprodutos_id_fornecedor_fkey FOREIGN KEY (id_fornecedor) REFERENCES public.fornecedores(id_fornecedor);


--
-- TOC entry 4742 (class 2606 OID 33369)
-- Name: fornecedoresprodutos fornecedoresprodutos_id_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedoresprodutos
    ADD CONSTRAINT fornecedoresprodutos_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES public.produtos(id_produto);


--
-- TOC entry 4739 (class 2606 OID 33339)
-- Name: itensdavenda itensdavenda_id_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itensdavenda
    ADD CONSTRAINT itensdavenda_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES public.produtos(id_produto);


--
-- TOC entry 4740 (class 2606 OID 33334)
-- Name: itensdavenda itensdavenda_id_venda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itensdavenda
    ADD CONSTRAINT itensdavenda_id_venda_fkey FOREIGN KEY (id_venda) REFERENCES public.vendas(id_venda);


--
-- TOC entry 4737 (class 2606 OID 33296)
-- Name: produtos produtos_id_categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria);


--
-- TOC entry 4738 (class 2606 OID 33322)
-- Name: vendas vendas_id_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente);


-- Completed on 2024-09-17 16:32:40

--
-- PostgreSQL database dump complete
--

