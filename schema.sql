--USER
CREATE TABLE "user" (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  first_name VARCHAR NULL DEFAULT NULL,
  middle_name VARCHAR NULL DEFAULT NULL,
  last_name VARCHAR NULL DEFAULT NULL,
  mobile VARCHAR NULL,
  email VARCHAR NULL,
  password_hash VARCHAR NOT NULL,
  admin BOOLEAN NOT NULL DEFAULT false,
  vendor BOOLEAN NOT NULL DEFAULT true,
  registered_at TIMESTAMPTZ NOT NULL,
  lastLogin TIMESTAMPTZ NULL DEFAULT NULL,
  intro TEXT NULL DEFAULT NULL,
  profile TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE UNIQUE INDEX uq_mobile ON "user" (mobile ASC);
CREATE UNIQUE INDEX uq_email ON "user" (email ASC);
  
--PRODUCT
CREATE TABLE "product" (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  user_id BIGINT NOT NULL,
  title VARCHAR NOT NULL,
  meta_title VARCHAR NULL,
  slug VARCHAR NOT NULL,
  summary TEXT NULL,
  type SMALLINT NOT NULL DEFAULT 0,
  sku VARCHAR NOT NULL,
  price FLOAT NOT NULL DEFAULT 0,
  discount FLOAT NOT NULL DEFAULT 0,
  quantity SMALLINT NOT NULL DEFAULT 0,
  shop BOOLEAN NOT NULL DEFAULT false,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  published_at TIMESTAMPTZ NULL DEFAULT NULL,
  starts_at TIMESTAMPTZ NULL DEFAULT NULL,
  ends_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_product_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id));
	
CREATE INDEX idx_product_user ON "product" (user_id);
CREATE UNIQUE INDEX uq_slug ON "product" (slug ASC);
	
--PRODUCT_REVIEW
CREATE TABLE product_review (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  product_id BIGINT NOT NULL,
  parent_id BIGINT NULL DEFAULT NULL,
  title VARCHAR NOT NULL,
  rating SMALLINT NOT NULL DEFAULT 0,
  published BOOLEAN NOT NULL DEFAULT false,
  created_at TIMESTAMPTZ NOT NULL,
  published_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_review_product
    FOREIGN KEY (product_id)
    REFERENCES product (id),
  CONSTRAINT fk_review_parent
    FOREIGN KEY (parent_id)
    REFERENCES product_review (id)
	);

CREATE INDEX idx_review_product ON product_review (product_id ASC);
CREATE INDEX idx_review_parent ON product_review (parent_id ASC);
  
--CATEGORY
CREATE TABLE category (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  parent_id BIGINT NULL DEFAULT NULL,
  title VARCHAR NOT NULL,
  meta_title VARCHAR NULL DEFAULT NULL,
  slug VARCHAR NOT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_category_parent
	FOREIGN KEY (parent_id)
	REFERENCES category (id)
);

CREATE INDEX idx_category_parent ON category (parent_id ASC);

--PRODUCT_CATEGORY
CREATE TABLE product_category (
  product_id BIGINT NOT NULL,
  category_id BIGINT NOT NULL,
  PRIMARY KEY (product_id, category_id),
  CONSTRAINT fk_pc_product
    FOREIGN KEY (product_id)
    REFERENCES product (id),
  CONSTRAINT fk_pc_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)
);
	
CREATE  INDEX idx_pc_category ON product_category (category_id ASC);
CREATE  INDEX idx_pc_product ON product_category (product_id ASC);

--CART
CREATE TABLE cart (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  user_id BIGINT NULL DEFAULT NULL,
  session_id VARCHAR NOT NULL,
  token VARCHAR NOT NULL,
  status SMALLINT NOT NULL DEFAULT 0,
  first_name VARCHAR NULL DEFAULT NULL,
  middle_name VARCHAR NULL DEFAULT NULL,
  last_name VARCHAR NULL DEFAULT NULL,
  mobile VARCHAR NULL,
  email VARCHAR NULL,
  line1 VARCHAR NULL DEFAULT NULL,
  line2 VARCHAR NULL DEFAULT NULL,
  city VARCHAR NULL DEFAULT NULL,
  province VARCHAR NULL DEFAULT NULL,
  country VARCHAR NULL DEFAULT NULL,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_cart_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)
);

CREATE INDEX idx_cart_user ON cart (user_id);

--CART_ITEM
CREATE TABLE cart_item (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  product_id BIGINT NOT NULL,
  cart_id BIGINT NOT NULL,
  sku VARCHAR NOT NULL,
  price FLOAT NOT NULL DEFAULT 0,
  discount FLOAT NOT NULL DEFAULT 0,
  quantity SMALLINT NOT NULL DEFAULT 0,
  active BOOLEAN NOT NULL DEFAULT false,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_cart_item_product
    FOREIGN KEY (product_id)
    REFERENCES product (id),
  CONSTRAINT fk_cart_item_cart
    FOREIGN KEY (cart_id)
    REFERENCES cart (id)
);

CREATE INDEX idx_cart_item_product ON cart_item (product_id ASC);
CREATE INDEX idx_cart_item_cart ON cart_item (cart_id ASC);
  
--ORDER
CREATE TABLE "order" (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  user_id BIGINT NULL DEFAULT NULL,
  session_id VARCHAR NOT NULL,
  token VARCHAR NOT NULL,
  status SMALLINT NOT NULL DEFAULT 0,
  subTotal FLOAT NOT NULL DEFAULT 0,
  itemDiscount FLOAT NOT NULL DEFAULT 0,
  tax FLOAT NOT NULL DEFAULT 0,
  shipping FLOAT NOT NULL DEFAULT 0,
  total FLOAT NOT NULL DEFAULT 0,
  promo VARCHAR NULL DEFAULT NULL,
  discount FLOAT NOT NULL DEFAULT 0,
  grandTotal FLOAT NOT NULL DEFAULT 0,
  first_name VARCHAR NULL DEFAULT NULL,
  middle_name VARCHAR NULL DEFAULT NULL,
  last_name VARCHAR NULL DEFAULT NULL,
  mobile VARCHAR NULL,
  email VARCHAR NULL,
  line1 VARCHAR NULL DEFAULT NULL,
  line2 VARCHAR NULL DEFAULT NULL,
  city VARCHAR NULL DEFAULT NULL,
  province VARCHAR NULL DEFAULT NULL,
  country VARCHAR NULL DEFAULT NULL,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_order_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)
);

CREATE INDEX idx_order_user ON "order" (user_id);

--ORDER_ITEM
CREATE TABLE order_item (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  product_id BIGINT NOT NULL,
  order_id BIGINT NOT NULL,
  sku VARCHAR NOT NULL,
  price FLOAT NOT NULL DEFAULT 0,
  discount FLOAT NOT NULL DEFAULT 0,
  quantity SMALLINT NOT NULL DEFAULT 0,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_order_item_product
    FOREIGN KEY (product_id)
    REFERENCES product (id),
  CONSTRAINT fk_order_item_order
	FOREIGN KEY (order_id)
	REFERENCES "order" (id)
);

CREATE INDEX idx_order_item_product ON order_item (product_id ASC);
CREATE INDEX idx_order_item_order ON order_item (order_id ASC);
  
--TRANSACTION
CREATE TABLE transaction (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  user_id BIGINT NOT NULL,
  order_id BIGINT NOT NULL,
  code VARCHAR NOT NULL,
  type SMALLINT NOT NULL DEFAULT 0,
  mode SMALLINT NOT NULL DEFAULT 0,
  status SMALLINT NOT NULL DEFAULT 0,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NULL DEFAULT NULL,
  content TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_transaction_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id),
  CONSTRAINT fk_transaction_order
	FOREIGN KEY (order_id)
	REFERENCES "order" (id)
);

CREATE INDEX idx_transaction_user ON transaction (user_id ASC);
CREATE INDEX idx_transaction_order ON transaction (order_id ASC);