CREATE TABLE public.tb_order (
	id numeric NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	vl_total decimal NULL,
	status varchar NULL,
	nr_order varchar NOT NULL,
	CONSTRAINT tb_order_pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX tb_order_nr_order_idx ON public.tb_order (nr_order);

CREATE TABLE public.tb_item_order (
    id numeric NOT NULL,
	order_id numeric NOT NULL,
	nr_item integer NOT NULL,
	cd_product numeric NOT NULL,
	qty float4 NOT NULL,
	vl_unit decimal NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	CONSTRAINT tb_item_order_pk PRIMARY KEY (id),
	constraint fk_tb_order
         foreign key (order_id)
         REFERENCES public.tb_order (id)
);

CREATE SEQUENCE tb_order_seq;

CREATE INDEX tb_item_order_idx ON public.tb_item_order (order_id, nr_item);
