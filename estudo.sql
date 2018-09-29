--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.22
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-1.pgdg14.04+1)

-- Started on 2018-09-26 11:21:42 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 142 (class 1259 OID 23896)
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cidade (
    id integer NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.cidade OWNER TO postgres;

--
-- TOC entry 141 (class 1259 OID 23894)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 140 (class 1259 OID 23889)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id integer NOT NULL,
    cpf bigint NOT NULL,
    nome character varying(255),
    numcontato integer NOT NULL,
    rg bigint NOT NULL
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 1781 (class 0 OID 23896)
-- Dependencies: 142
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cidade VALUES (3, 'Candido Mota');
INSERT INTO public.cidade VALUES (4, 'Assis');
INSERT INTO public.cidade VALUES (5, 'Palmital');
INSERT INTO public.cidade VALUES (6, 'Ourinhos');
INSERT INTO public.cidade VALUES (7, 'Platina');
INSERT INTO public.cidade VALUES (10, 'Sao Paulo');


--
-- TOC entry 1779 (class 0 OID 23889)
-- Dependencies: 140
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pessoa VALUES (2, 32123123, 'Juliana', 424525234, 32442243);
INSERT INTO public.pessoa VALUES (20, 123123123, 'JhonatasHB', 12345567, 321321321);
INSERT INTO public.pessoa VALUES (1, 123123132, 'Izabela', 2131321, 1231231);


--
-- TOC entry 1790 (class 0 OID 0)
-- Dependencies: 141
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 21, true);


--
-- TOC entry 1692 (class 2606 OID 23900)
-- Name: cidade cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);


--
-- TOC entry 1690 (class 2606 OID 23893)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 1789 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-09-26 11:21:42 -03

--
-- PostgreSQL database dump complete
--

