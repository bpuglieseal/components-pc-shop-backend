-- Users
INSERT INTO users (name, email, password, direction, birthdate, role) VALUES
('Ana Martínez', 'ana.martinez@mail.com', 'Pass1234!', 'Calle 12 #45-67, Madrid', DATE '1995-06-12', 'USER'),
('Juan Pérez', 'juan.perez@mail.com', 'Secure987@', 'Av. Siempre Viva 123', DATE '1990-03-08', 'ADMIN'),
('Laura Fernández', 'laura.fernandez@mail.com', 'Pwd456!$', 'Calle Falsa 123, Sevilla', DATE '1988-11-22', 'USER'),
('Carlos Gómez', 'carlos.gomez@mail.com', 'CarlPass1#', 'Ronda del Sol 58, Málaga', DATE '1999-01-17', 'USER'),
('Elena Ruiz', 'elena.ruiz@mail.com', 'Ruiz_2024!', 'Plaza Mayor 5, Valencia', DATE '1985-07-04', 'ADMIN');

-- Suppliers Table
INSERT INTO suppliers (name, country) VALUES
('TechGlobal Components', 'Estados Unidos'),
('InovaChips', 'Alemania'),
('DigitalCore Solutions', 'Japón'),
('EuroTech Supply', 'España'),
('Andes Hardware', 'Chile');

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

-- Products
INSERT INTO products (name, price, rating, supplier_id, stock, image, category_id) VALUES
('Intel Core i9-13900K', 639.99, 4.9, 1, 50, 'intel_i9.jpg', 1),
('AMD Ryzen 7 7800X3D', 499.50, 4.8, 2, 70, 'ryzen_7800x3d.jpg', 1),
('NVIDIA GeForce RTX 4090', 1599.00, 4.9, 3, 25, 'rtx_4090.jpg', 2),
('ASUS ROG Strix Z790-E', 389.00, 4.7, 4, 40, 'asus_z790e.jpg', 3),
('Corsair Vengeance 32GB DDR5', 169.99, 4.6, 1, 80, 'corsair_32gb.jpg', 4),
('Samsung 980 PRO 1TB NVMe SSD', 129.00, 4.8, 3, 90, 'samsung_980pro.jpg', 5),
('Corsair RM850x 850W 80+ Gold', 139.90, 4.7, 5, 65, 'corsair_rm850x.jpg', 6),
('NZXT H510 Elite Mid Tower', 149.99, 4.5, 2, 30, 'nzxt_h510.jpg', 7),
('Noctua NH-D15', 89.00, 4.9, 4, 55, 'noctua_nhd15.jpg', 8),
('Logitech G Pro X Superlight', 129.00, 4.6, 1, 100, 'logitech_superlight.jpg', 9),
('Dell S2721DGF 27" QHD 165Hz', 379.00, 4.8, 2, 35, 'dell_s2721dgf.jpg', 10),
('SteelSeries Arctis Nova 7', 179.99, 4.7, 5, 75, 'steelseries_nova7.jpg', 11),
('AMD Radeon RX 7900 XTX', 999.00, 4.7, 2, 35, 'rx_7900xtx.jpg', 2),
('MSI B650 Tomahawk WiFi', 229.99, 4.5, 3, 60, 'msi_b650.jpg', 3),
('G.Skill Trident Z5 RGB 32GB DDR5', 189.00, 4.8, 1, 50, 'gskill_z5.jpg', 4),
('Western Digital Black SN850X 2TB', 229.99, 4.9, 3, 40, 'wd_black_sn850x.jpg', 5),
('EVGA SuperNOVA 750 G6', 119.90, 4.6, 4, 70, 'evga_750g6.jpg', 6),
( 'Phanteks Eclipse G360A', 99.99, 4.4, 5, 45, 'phanteks_g360a.jpg', 7),
('Be Quiet! Dark Rock Pro 4', 84.90, 4.8, 2, 50, 'darkrock_pro4.jpg', 8),
('Razer BlackWidow V3 Pro', 179.00, 4.5, 1, 80, 'razer_blackwidowv3.jpg', 9),
('Gigabyte M27Q 27" 170Hz', 289.99, 4.7, 4, 25, 'gigabyte_m27q.jpg', 10),
('HyperX Cloud II Wireless', 109.90, 4.6, 5, 60, 'hyperx_cloudii.jpg', 11),
('TP-Link Archer AX73 WiFi 6', 129.00, 4.5, 3, 35, 'tplink_ax73.jpg', 12),
('Intel Core i5-13600KF', 319.99, 4.8, 1, 65, 'intel_i5_13600kf.jpg', 1),
('AMD Ryzen 5 7600X', 259.00, 4.7, 2, 70, 'ryzen_7600x.jpg', 1),
('ASRock B760M Steel Legend', 149.99, 4.3, 4, 55, 'asrock_b760m.jpg', 3),
('ADATA XPG Lancer RGB 16GB DDR5', 89.90, 4.6, 2, 100, 'adata_lancer.jpg', 4),
('Kingston NV2 1TB M.2 SSD', 74.99, 4.7, 3, 120, 'kingston_nv2.jpg', 5),
('Cooler Master MWE Gold 750W', 109.00, 4.5, 5, 50, 'cm_mwe750.jpg', 6),
('Thermaltake S100 TG Micro-ATX', 69.99, 4.3, 4, 40, 'tt_s100.jpg', 7),
('ARCTIC Liquid Freezer II 360', 119.90, 4.8, 2, 30, 'arctic_lf2.jpg', 8),
('SteelSeries Apex Pro TKL', 189.99, 4.9, 1, 45, 'apex_pro_tkl.jpg', 9),
('ASUS TUF Gaming VG27AQ', 319.00, 4.7, 3, 35, 'asus_vg27aq.jpg', 10),
('Logitech G733 Lightspeed', 139.90, 4.6, 1, 50, 'logitech_g733.jpg', 11),
('Intel Wi-Fi 6 AX200 Adapter', 39.99, 4.5, 3, 75, 'intel_ax200.jpg', 12),
('Ryzen 9 7950X3D', 699.00, 4.9, 2, 25, 'ryzen_7950x3d.jpg', 1),
('ASUS Prime X670-P WiFi', 289.00, 4.6, 3, 50, 'asus_x670.jpg', 3),
('Patriot Viper Venom 32GB DDR5', 159.90, 4.7, 4, 80, 'patriot_venom.jpg', 4),
('PNY CS2241 1TB SSD Gen4', 79.99, 4.4, 5, 60, 'pny_cs2241.jpg', 5),
('Be Quiet! Pure Power 11 600W', 84.90, 4.5, 2, 70, 'purepower11.jpg', 6),
('Corsair 4000D Airflow Mid-Tower', 104.99, 4.8, 1, 65, 'corsair_4000d.jpg', 7),
('NZXT Kraken Elite 280 RGB', 159.90, 4.7, 5, 40, 'nzxt_kraken280.jpg', 8);