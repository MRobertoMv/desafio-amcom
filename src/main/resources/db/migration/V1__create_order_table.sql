CREATE TABLE public.order (
	id numeric NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	vl_total decimal NULL,
	status varchar NULL,
	nro_order varchar NOT NULL,
	CONSTRAINT order_pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX order_nro_order_idx ON public.order (nro_order);

CREATE TABLE public.item_order (
	order_id numeric NOT NULL,
	nro_item integer NOT NULL,
	cd_product numeric NOT NULL,
	qty float4 NOT NULL,
	vl_unit decimal NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NULL,
	PRIMARY KEY (order_id, nro_item),
	constraint fk_order
         foreign key (order_id)
         REFERENCES public.order (id)
);
