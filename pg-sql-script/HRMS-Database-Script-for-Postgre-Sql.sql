--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-06-02 19:38:35

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
-- TOC entry 206 (class 1259 OID 32799)
-- Name: job_titles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.job_titles OWNER TO postgres;

--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE job_titles; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.job_titles IS 'Job Titles';


--
-- TOC entry 205 (class 1259 OID 32797)
-- Name: Titles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Titles_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Titles_id_seq" OWNER TO postgres;

--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 205
-- Name: Titles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Titles_id_seq" OWNED BY public.job_titles.id;


--
-- TOC entry 201 (class 1259 OID 32770)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(320) NOT NULL,
    password character(56) NOT NULL,
    verified boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE users; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.users IS 'base users table';


--
-- TOC entry 200 (class 1259 OID 32768)
-- Name: Users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Users_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Users_id_seq" OWNER TO postgres;

--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 200
-- Name: Users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Users_id_seq" OWNED BY public.users.id;


--
-- TOC entry 203 (class 1259 OID 32781)
-- Name: employer_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer_users (
    "userId" integer NOT NULL,
    "companyName" character varying(255) NOT NULL,
    "webSite" character varying(253) NOT NULL,
    "phoneNumber" character(11) NOT NULL,
    "verifiedCompany" boolean NOT NULL
);


ALTER TABLE public.employer_users OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 32892)
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
-- TOC entry 204 (class 1259 OID 32789)
-- Name: job_seeker_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seeker_users (
    "UserId" integer NOT NULL,
    "firstName" character varying(255) NOT NULL,
    "lastName" character varying(255) NOT NULL,
    "nationalIdentity" character(11) NOT NULL,
    "yearOfBirth" character(4) NOT NULL
);


ALTER TABLE public.job_seeker_users OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32776)
-- Name: system_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_users (
    "userId" integer NOT NULL
);


ALTER TABLE public.system_users OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 32805)
-- Name: verification_tokens; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.verification_tokens (
    "userId" integer NOT NULL,
    token character varying(100) NOT NULL
);


ALTER TABLE public.verification_tokens OWNER TO postgres;

--
-- TOC entry 2877 (class 2604 OID 32802)
-- Name: job_titles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles ALTER COLUMN id SET DEFAULT nextval('public."Titles_id_seq"'::regclass);


--
-- TOC entry 2876 (class 2604 OID 32773)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public."Users_id_seq"'::regclass);


--
-- TOC entry 2892 (class 2606 OID 32788)
-- Name: employer_users employer_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT employer_users_pkey PRIMARY KEY ("userId");


--
-- TOC entry 2894 (class 2606 OID 32845)
-- Name: employer_users employer_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT "employer_users_userId_unique" UNIQUE ("userId");


--
-- TOC entry 2897 (class 2606 OID 32884)
-- Name: job_seeker_users job_seeker_users_nationalIdentity_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT "job_seeker_users_nationalIdentity_unique" UNIQUE ("nationalIdentity");


--
-- TOC entry 2899 (class 2606 OID 32796)
-- Name: job_seeker_users job_seeker_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT job_seeker_users_pkey PRIMARY KEY ("UserId");


--
-- TOC entry 2901 (class 2606 OID 32847)
-- Name: job_seeker_users job_seeker_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT "job_seeker_users_userId_unique" UNIQUE ("UserId");


--
-- TOC entry 2903 (class 2606 OID 32851)
-- Name: job_titles job_titles_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_id_unique UNIQUE (id);


--
-- TOC entry 2906 (class 2606 OID 32804)
-- Name: job_titles job_titles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);


--
-- TOC entry 2908 (class 2606 OID 32853)
-- Name: job_titles job_titles_title_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_title_unique UNIQUE (title);


--
-- TOC entry 2887 (class 2606 OID 32780)
-- Name: system_users system_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_users_pkey PRIMARY KEY ("userId");


--
-- TOC entry 2889 (class 2606 OID 32843)
-- Name: system_users system_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT "system_users_userId_unique" UNIQUE ("userId");


--
-- TOC entry 2879 (class 2606 OID 32886)
-- Name: users users_email_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_unique UNIQUE (email);


--
-- TOC entry 2881 (class 2606 OID 32849)
-- Name: users users_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_unique UNIQUE (id);


--
-- TOC entry 2884 (class 2606 OID 32775)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2911 (class 2606 OID 32809)
-- Name: verification_tokens verification_tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT verification_tokens_pkey PRIMARY KEY ("userId");


--
-- TOC entry 2890 (class 1259 OID 32855)
-- Name: employer_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX employer_users_index ON public.employer_users USING btree ("userId");


--
-- TOC entry 2895 (class 1259 OID 32854)
-- Name: job_seeker_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX job_seeker_users_index ON public.job_seeker_users USING btree ("UserId");


--
-- TOC entry 2904 (class 1259 OID 32856)
-- Name: job_titles_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX job_titles_index ON public.job_titles USING btree (id);


--
-- TOC entry 2885 (class 1259 OID 32857)
-- Name: system_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX system_users_index ON public.system_users USING btree ("userId");


--
-- TOC entry 2882 (class 1259 OID 32858)
-- Name: users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX users_index ON public.users USING btree (id);


--
-- TOC entry 2909 (class 1259 OID 32859)
-- Name: verification_tokens_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX verification_tokens_index ON public.verification_tokens USING btree ("userId");


--
-- TOC entry 2913 (class 2606 OID 32815)
-- Name: employer_users employer_users_userId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT "employer_users_userId_fkey" FOREIGN KEY ("userId") REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2914 (class 2606 OID 32820)
-- Name: job_seeker_users job_seeker_users_UserId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT "job_seeker_users_UserId_fkey" FOREIGN KEY ("UserId") REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2912 (class 2606 OID 32810)
-- Name: system_users system_users_userId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT "system_users_userId_fkey" FOREIGN KEY ("userId") REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2915 (class 2606 OID 32825)
-- Name: verification_tokens verification_tokens_userId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT "verification_tokens_userId_fkey" FOREIGN KEY ("userId") REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-06-02 19:38:36

--
-- PostgreSQL database dump complete
--

