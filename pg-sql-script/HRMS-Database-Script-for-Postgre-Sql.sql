--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-06-26 19:46:06

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
-- TOC entry 204 (class 1259 OID 32799)
-- Name: job_titles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.job_titles OWNER TO postgres;

--
-- TOC entry 3179 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE job_titles; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.job_titles IS 'Job Titles';


--
-- TOC entry 203 (class 1259 OID 32797)
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
-- TOC entry 3180 (class 0 OID 0)
-- Dependencies: 203
-- Name: Titles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Titles_id_seq" OWNED BY public.job_titles.id;


--
-- TOC entry 211 (class 1259 OID 33105)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    code integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 33340)
-- Name: cover_letters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cover_letters (
    id integer NOT NULL,
    job_seeker_user_id integer NOT NULL,
    title character varying(50) NOT NULL,
    body character varying(4000) NOT NULL
);


ALTER TABLE public.cover_letters OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 33338)
-- Name: cover_letters_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cover_letters ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cover_letters_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 212 (class 1259 OID 33160)
-- Name: cvs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cvs (
    id integer NOT NULL,
    job_seeker_user_id integer,
    cover_letter_id integer,
    skills character varying(500)
);


ALTER TABLE public.cvs OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 33172)
-- Name: cv_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cvs ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cv_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 33289)
-- Name: cvs_languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cvs_languages (
    id integer NOT NULL,
    cv_id integer NOT NULL,
    language_id integer NOT NULL,
    level character varying(1) NOT NULL
);


ALTER TABLE public.cvs_languages OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33287)
-- Name: cvs_languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cvs_languages ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cvs_languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 33163)
-- Name: educations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.educations (
    id integer NOT NULL,
    cv_id integer NOT NULL,
    institution_name character varying(100) NOT NULL,
    department character varying(100),
    starting_date date NOT NULL,
    completion_date date
);


ALTER TABLE public.educations OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 32781)
-- Name: employer_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer_users (
    user_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    website character varying(253) NOT NULL,
    phone_number character(11) NOT NULL,
    verified_company boolean
);


ALTER TABLE public.employer_users OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 33266)
-- Name: experiences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.experiences (
    id integer NOT NULL,
    cv_id integer,
    company_name character varying(100),
    title character varying(50),
    start_date date,
    end_date date
);


ALTER TABLE public.experiences OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 33264)
-- Name: experiences_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.experiences ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.experiences_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 206 (class 1259 OID 32892)
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
-- TOC entry 229 (class 1259 OID 33388)
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.images (
    id integer NOT NULL,
    image_url character varying(2048) NOT NULL,
    alt character varying(100),
    user_id integer
);


ALTER TABLE public.images OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32789)
-- Name: job_seeker_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seeker_users (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    national_identity character(11) NOT NULL,
    year_of_birth character(4) NOT NULL
);


ALTER TABLE public.job_seeker_users OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 33081)
-- Name: jobs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jobs (
    id integer NOT NULL,
    employer_user_id integer NOT NULL,
    job_title_id integer NOT NULL,
    city_code integer NOT NULL,
    description text NOT NULL,
    min_salary character varying(13),
    vacancy smallint NOT NULL,
    posting_date date NOT NULL,
    last_application_date date NOT NULL,
    active boolean DEFAULT false NOT NULL,
    max_salary character varying(13),
    remote boolean DEFAULT false NOT NULL,
    full_time boolean DEFAULT false NOT NULL
);


ALTER TABLE public.jobs OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 33079)
-- Name: jobs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.jobs ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.jobs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 33281)
-- Name: languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.languages (
    id integer NOT NULL,
    name character varying(49) NOT NULL,
    iso_639_1 character(2) NOT NULL
);


ALTER TABLE public.languages OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33279)
-- Name: languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.languages ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 228 (class 1259 OID 33386)
-- Name: profile_photos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.images ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.profile_photos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 215 (class 1259 OID 33186)
-- Name: seeker_educations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.educations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.seeker_educations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 33320)
-- Name: social_links; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.social_links (
    id integer NOT NULL,
    social_platform_id integer NOT NULL,
    cv_id integer NOT NULL,
    profile_name character varying(100) NOT NULL
);


ALTER TABLE public.social_links OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33318)
-- Name: social_links_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.social_links ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.social_links_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 33312)
-- Name: social_platforms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.social_platforms (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    url character varying(100) NOT NULL
);


ALTER TABLE public.social_platforms OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33310)
-- Name: social_platforms_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.social_platforms ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.social_platforms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 200 (class 1259 OID 32776)
-- Name: system_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_users (
    user_id integer NOT NULL
);


ALTER TABLE public.system_users OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 32991)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(320) NOT NULL,
    password character(56) NOT NULL,
    active boolean DEFAULT false NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 3181 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE users; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.users IS 'base users table';


--
-- TOC entry 207 (class 1259 OID 32989)
-- Name: users_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 32805)
-- Name: verification_tokens; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.verification_tokens (
    user_id integer NOT NULL,
    token character varying(100) NOT NULL
);


ALTER TABLE public.verification_tokens OWNER TO postgres;

--
-- TOC entry 2943 (class 2604 OID 32802)
-- Name: job_titles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles ALTER COLUMN id SET DEFAULT nextval('public."Titles_id_seq"'::regclass);


--
-- TOC entry 2989 (class 2606 OID 33110)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (code);


--
-- TOC entry 3021 (class 2606 OID 33347)
-- Name: cover_letters cover_letters_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cover_letters
    ADD CONSTRAINT cover_letters_pkey PRIMARY KEY (id);


--
-- TOC entry 3008 (class 2606 OID 33293)
-- Name: cvs_languages cvs_languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs_languages
    ADD CONSTRAINT cvs_languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2992 (class 2606 OID 33178)
-- Name: cvs cvs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs
    ADD CONSTRAINT cvs_pkey PRIMARY KEY (id);


--
-- TOC entry 2955 (class 2606 OID 32788)
-- Name: employer_users employer_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT employer_users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2957 (class 2606 OID 32962)
-- Name: employer_users employer_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT "employer_users_userId_unique" UNIQUE (user_id);


--
-- TOC entry 3001 (class 2606 OID 33270)
-- Name: experiences experiences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experiences
    ADD CONSTRAINT experiences_pkey PRIMARY KEY (id);


--
-- TOC entry 3025 (class 2606 OID 33395)
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (id);


--
-- TOC entry 2960 (class 2606 OID 32884)
-- Name: job_seeker_users job_seeker_users_nationalIdentity_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT "job_seeker_users_nationalIdentity_unique" UNIQUE (national_identity);


--
-- TOC entry 2962 (class 2606 OID 32796)
-- Name: job_seeker_users job_seeker_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT job_seeker_users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2964 (class 2606 OID 32960)
-- Name: job_seeker_users job_seeker_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT "job_seeker_users_userId_unique" UNIQUE (user_id);


--
-- TOC entry 2966 (class 2606 OID 32851)
-- Name: job_titles job_titles_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_id_unique UNIQUE (id);


--
-- TOC entry 2969 (class 2606 OID 32804)
-- Name: job_titles job_titles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);


--
-- TOC entry 2971 (class 2606 OID 32853)
-- Name: job_titles job_titles_title_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_title_unique UNIQUE (title);


--
-- TOC entry 2986 (class 2606 OID 33085)
-- Name: jobs jobs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_pkey PRIMARY KEY (id);


--
-- TOC entry 3005 (class 2606 OID 33286)
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2998 (class 2606 OID 33192)
-- Name: educations seeker_educations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.educations
    ADD CONSTRAINT seeker_educations_pkey PRIMARY KEY (id);


--
-- TOC entry 3018 (class 2606 OID 33324)
-- Name: social_links social_links_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.social_links
    ADD CONSTRAINT social_links_pkey PRIMARY KEY (id);


--
-- TOC entry 3013 (class 2606 OID 33316)
-- Name: social_platforms social_platforms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.social_platforms
    ADD CONSTRAINT social_platforms_pkey PRIMARY KEY (id);


--
-- TOC entry 2950 (class 2606 OID 32780)
-- Name: system_users system_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2952 (class 2606 OID 32843)
-- Name: system_users system_users_userId_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT "system_users_userId_unique" UNIQUE (user_id);


--
-- TOC entry 2976 (class 2606 OID 33020)
-- Name: users users_email_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_unique UNIQUE (email);


--
-- TOC entry 2978 (class 2606 OID 33023)
-- Name: users users_id_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2980 (class 2606 OID 33021)
-- Name: users users_id_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_id_unique UNIQUE (id);


--
-- TOC entry 2974 (class 2606 OID 32809)
-- Name: verification_tokens verification_tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT verification_tokens_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2987 (class 1259 OID 33108)
-- Name: cities_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX cities_index ON public.cities USING btree (code);


--
-- TOC entry 3019 (class 1259 OID 33348)
-- Name: cover_letters_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX cover_letters_index ON public.cover_letters USING btree (id);


--
-- TOC entry 3006 (class 1259 OID 33294)
-- Name: cvc_languages_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX cvc_languages_index ON public.cvs_languages USING btree (id);


--
-- TOC entry 2990 (class 1259 OID 33179)
-- Name: cvs_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX cvs_index ON public.cvs USING btree (id);


--
-- TOC entry 2995 (class 1259 OID 33199)
-- Name: educations_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX educations_index ON public.educations USING btree (id);


--
-- TOC entry 2953 (class 1259 OID 33048)
-- Name: employer_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX employer_users_index ON public.employer_users USING btree (user_id);


--
-- TOC entry 2999 (class 1259 OID 33271)
-- Name: experiences_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX experiences_index ON public.experiences USING btree (id);


--
-- TOC entry 3022 (class 1259 OID 33354)
-- Name: fki_cover_letters_job_seeker_user_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cover_letters_job_seeker_user_id_fkey ON public.cover_letters USING btree (job_seeker_user_id);


--
-- TOC entry 2993 (class 1259 OID 33360)
-- Name: fki_cvs_cover_letter_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cvs_cover_letter_id_fkey ON public.cvs USING btree (cover_letter_id);


--
-- TOC entry 2994 (class 1259 OID 33185)
-- Name: fki_cvs_job_seeker_user_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cvs_job_seeker_user_id_fkey ON public.cvs USING btree (job_seeker_user_id);


--
-- TOC entry 3009 (class 1259 OID 33300)
-- Name: fki_cvs_languages_cv_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cvs_languages_cv_id_fkey ON public.cvs_languages USING btree (cv_id);


--
-- TOC entry 3010 (class 1259 OID 33306)
-- Name: fki_cvs_languages_language_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cvs_languages_language_id_fkey ON public.cvs_languages USING btree (language_id);


--
-- TOC entry 2996 (class 1259 OID 33198)
-- Name: fki_educations_cv_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_educations_cv_id_fkey ON public.educations USING btree (cv_id);


--
-- TOC entry 3002 (class 1259 OID 33277)
-- Name: fki_experiences_cv_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_experiences_cv_id_fkey ON public.experiences USING btree (cv_id);


--
-- TOC entry 2981 (class 1259 OID 33116)
-- Name: fki_jobs_city_code_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_jobs_city_code_fkey ON public.jobs USING btree (city_code);


--
-- TOC entry 2982 (class 1259 OID 33096)
-- Name: fki_jobs_employer_user_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_jobs_employer_user_id_fkey ON public.jobs USING btree (employer_user_id);


--
-- TOC entry 2983 (class 1259 OID 33102)
-- Name: fki_jobs_job_title_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_jobs_job_title_id_fkey ON public.jobs USING btree (job_title_id);


--
-- TOC entry 3014 (class 1259 OID 33337)
-- Name: fki_social_links_cv_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_social_links_cv_id_fkey ON public.social_links USING btree (cv_id);


--
-- TOC entry 3015 (class 1259 OID 33331)
-- Name: fki_social_links_social_platform_id_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_social_links_social_platform_id_fkey ON public.social_links USING btree (social_platform_id);


--
-- TOC entry 3023 (class 1259 OID 33396)
-- Name: images_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX images_index ON public.images USING btree (id);


--
-- TOC entry 2958 (class 1259 OID 32961)
-- Name: job_seeker_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX job_seeker_users_index ON public.job_seeker_users USING btree (user_id);


--
-- TOC entry 2967 (class 1259 OID 32856)
-- Name: job_titles_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX job_titles_index ON public.job_titles USING btree (id);


--
-- TOC entry 2984 (class 1259 OID 33090)
-- Name: jobs_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX jobs_index ON public.jobs USING btree (id);


--
-- TOC entry 3003 (class 1259 OID 33284)
-- Name: languages_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX languages_index ON public.languages USING btree (id);


--
-- TOC entry 3016 (class 1259 OID 33325)
-- Name: social_links_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX social_links_index ON public.social_links USING btree (id);


--
-- TOC entry 3011 (class 1259 OID 33317)
-- Name: social_platforms_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX social_platforms_index ON public.social_platforms USING btree (id);


--
-- TOC entry 2948 (class 1259 OID 32857)
-- Name: system_users_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX system_users_index ON public.system_users USING btree (user_id);


--
-- TOC entry 2972 (class 1259 OID 32859)
-- Name: verification_tokens_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX verification_tokens_index ON public.verification_tokens USING btree (user_id);


--
-- TOC entry 3042 (class 2606 OID 33349)
-- Name: cover_letters cover_letters_job_seeker_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cover_letters
    ADD CONSTRAINT cover_letters_job_seeker_user_id_fkey FOREIGN KEY (job_seeker_user_id) REFERENCES public.job_seeker_users(user_id) NOT VALID;


--
-- TOC entry 3034 (class 2606 OID 33355)
-- Name: cvs cvs_cover_letter_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs
    ADD CONSTRAINT cvs_cover_letter_id_fkey FOREIGN KEY (cover_letter_id) REFERENCES public.cover_letters(id) NOT VALID;


--
-- TOC entry 3033 (class 2606 OID 33180)
-- Name: cvs cvs_job_seeker_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs
    ADD CONSTRAINT cvs_job_seeker_user_id_fkey FOREIGN KEY (job_seeker_user_id) REFERENCES public.job_seeker_users(user_id) NOT VALID;


--
-- TOC entry 3038 (class 2606 OID 33295)
-- Name: cvs_languages cvs_languages_cv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs_languages
    ADD CONSTRAINT cvs_languages_cv_id_fkey FOREIGN KEY (cv_id) REFERENCES public.cvs(id) NOT VALID;


--
-- TOC entry 3039 (class 2606 OID 33301)
-- Name: cvs_languages cvs_languages_language_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs_languages
    ADD CONSTRAINT cvs_languages_language_id_fkey FOREIGN KEY (language_id) REFERENCES public.languages(id) NOT VALID;


--
-- TOC entry 3036 (class 2606 OID 33193)
-- Name: educations educations_cv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.educations
    ADD CONSTRAINT educations_cv_id_fkey FOREIGN KEY (cv_id) REFERENCES public.cvs(id) NOT VALID;


--
-- TOC entry 3027 (class 2606 OID 33074)
-- Name: employer_users employer_users_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT employer_users_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3037 (class 2606 OID 33272)
-- Name: experiences experiences_cv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experiences
    ADD CONSTRAINT experiences_cv_id_fkey FOREIGN KEY (cv_id) REFERENCES public.cvs(id) NOT VALID;


--
-- TOC entry 3043 (class 2606 OID 33403)
-- Name: images fk13ljqfrfwbyvnsdhihwta8cpr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT fk13ljqfrfwbyvnsdhihwta8cpr FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3035 (class 2606 OID 33361)
-- Name: cvs fknf0qg73c4plsui6t5ri2fd26x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cvs
    ADD CONSTRAINT fknf0qg73c4plsui6t5ri2fd26x FOREIGN KEY (cover_letter_id) REFERENCES public.job_seeker_users(user_id);


--
-- TOC entry 3028 (class 2606 OID 33054)
-- Name: job_seeker_users job_seeker_users_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seeker_users
    ADD CONSTRAINT job_seeker_users_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3032 (class 2606 OID 33111)
-- Name: jobs jobs_city_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_city_code_fkey FOREIGN KEY (city_code) REFERENCES public.cities(code) NOT VALID;


--
-- TOC entry 3030 (class 2606 OID 33091)
-- Name: jobs jobs_employer_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_employer_user_id_fkey FOREIGN KEY (employer_user_id) REFERENCES public.employer_users(user_id) NOT VALID;


--
-- TOC entry 3031 (class 2606 OID 33097)
-- Name: jobs jobs_job_title_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_job_title_id_fkey FOREIGN KEY (job_title_id) REFERENCES public.job_titles(id) NOT VALID;


--
-- TOC entry 3041 (class 2606 OID 33332)
-- Name: social_links social_links_cv_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.social_links
    ADD CONSTRAINT social_links_cv_id_fkey FOREIGN KEY (cv_id) REFERENCES public.cvs(id) NOT VALID;


--
-- TOC entry 3040 (class 2606 OID 33326)
-- Name: social_links social_links_social_platform_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.social_links
    ADD CONSTRAINT social_links_social_platform_id_fkey FOREIGN KEY (social_platform_id) REFERENCES public.social_platforms(id) NOT VALID;


--
-- TOC entry 3026 (class 2606 OID 33059)
-- Name: system_users system_users_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_users_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3029 (class 2606 OID 33064)
-- Name: verification_tokens verification_tokens_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT verification_tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-06-26 19:46:07

--
-- PostgreSQL database dump complete
--

