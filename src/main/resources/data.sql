INSERT INTO users (name, email, password, direction, birthdate, role) VALUES
('Ana Martínez', 'ana.martinez@mail.com', 'Pass1234!', 'Calle 12 #45-67, Madrid', DATE '1995-06-12', 'USER'),
('Juan Pérez', 'juan.perez@mail.com', 'Secure987@', 'Av. Siempre Viva 123', DATE '1990-03-08', 'ADMIN'),
('Laura Fernández', 'laura.fernandez@mail.com', 'Pwd456!$', 'Calle Falsa 123, Sevilla', DATE '1988-11-22', 'USER'),
('Carlos Gómez', 'carlos.gomez@mail.com', 'CarlPass1#', 'Ronda del Sol 58, Málaga', DATE '1999-01-17', 'USER'),
('Elena Ruiz', 'elena.ruiz@mail.com', 'Ruiz_2024!', 'Plaza Mayor 5, Valencia', DATE '1985-07-04', 'ADMIN');

-- Suppliers Table
INSERT INTO suppliers (name, country) VALUES
('TechGlobal S.A.', 'España'),
('Componentes del Norte', 'México'),
('EuroChip Distributors', 'Alemania'),
('Andes Hardware Ltda.', 'Chile'),
('Silicon Andes Corp.', 'Argentina'),
('Nordic Bits AB', 'Suecia'),
('Pacific Components Co.', 'Estados Unidos'),
('SmartTech Trading', 'Colombia'),
('Byte Factory Ltd.', 'Reino Unido'),
('Hardware Express S.A.', 'Brasil'),
('AlpinaTech GmbH', 'Austria'),
('Meditech Solutions', 'Canadá');

-- Categories Table
INSERT INTO categories (name, description) VALUES
('Procesadores', 'Unidades centrales de procesamiento de alto rendimiento'),
('Tarjetas Gráficas', 'GPUs para gaming, edición y renderizado'),
('Placas Base', 'Motherboards compatibles con diversas arquitecturas'),
('Memorias RAM', 'Módulos de memoria de distintas velocidades y capacidades'),
('Almacenamiento', 'Discos SSD y HDD para guardar tus datos'),
('Fuentes de Poder', 'Suministro eléctrico confiable para tu PC'),
('Gabinetes', 'Cajas con diseños y tamaños variados para ensamblar tu equipo'),
('Refrigeración', 'Soluciones térmicas: ventiladores, coolers y líquidas'),
('Periféricos', 'Teclados, ratones y otros accesorios externos'),
('Monitores', 'Pantallas para gaming, oficina y trabajo profesional'),
('Audio', 'Auriculares, altavoces y tarjetas de sonido'),
('Redes', 'Adaptadores, routers y tarjetas de red');