CREATE TABLE public.flight (
  flightid character varying(4) NULL,
  source character varying(36) NULL,
  destination character varying(36) NULL,
  terminal character varying(2) NULL,
  airplaneid character varying(5) NULL,
  pilotid integer NULL,
  airportid character varying(4) NULL,
  duration interval NULL,
  arrivingdate character varying(36) NULL,
  departdate character varying(36) NULL
);
;
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-555', 'NTGA', '2021-12-21 23:39:57', '2021-12-21 08:27:07', 'Aitutaki', NULL, 'CA71', 1, 'Anaa', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'DABB', '2021-12-22 06:19:37', '2021-12-21 12:59:08', 'Wainwright', NULL, 'XI15', 2, 'El Tarf', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'EKYT', '2021-12-21 14:17:05', '2021-12-21 11:55:30', 'Alliance', NULL, 'BS52', 3, 'Norresundby', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'FAMD', '2021-12-22 08:48:23', '2021-12-21 05:15:08', 'Al Hoceima', NULL, 'WG51', 4, 'Mala Mala', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'OMAL', '2021-12-21 20:24:41', '2021-12-20 19:45:41', 'Alghero', NULL, 'DI25', 5, 'Ayn al Faydah', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'URKA', '2021-12-22 03:35:02', '2021-12-21 07:37:41', 'Herlong', NULL, 'UD45', 6, 'Novorossiysk', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'EKAH', '2021-12-22 01:10:27', '2021-12-21 07:38:21', 'Hajlah', NULL, 'GS44', 7, 'Kolind', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'ZWAT', '2021-12-22 09:32:58', '2021-12-21 00:49:10', 'Agatti Island', NULL, 'CH07', 8, 'Altay', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'SBAX', '2021-12-22 08:26:40', '2021-12-21 03:24:30', 'Acarigua', NULL, 'AJ66', 9, 'Araxá', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'OYGD', '2021-12-22 10:25:23', '2021-12-20 19:30:24', 'Aguascalientes', NULL, 'ZH45', 10, 'Al Ghaydah', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'UNAA', '2021-12-21 17:30:42', '2021-12-21 06:35:59', 'Presidente Franco', NULL, 'TY50', 11, 'Abakan', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'LEAB', '2021-12-22 03:39:19', '2021-12-21 06:17:17', 'Augusta', NULL, 'JU47', 12, 'Albacete', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'KABE', '2021-12-22 06:35:59', '2021-12-21 06:44:44', 'Agra', NULL, 'ZB55', 13, 'Allentown', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'KABI', '2021-12-22 13:44:19', '2021-12-21 04:53:11', 'Malaga', NULL, 'RC13', 14, 'Abilene', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'DIAP', '2021-12-21 16:15:35', '2021-12-21 12:25:50', 'Angoon', NULL, 'PI31', 15, 'Abidjan', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'HAKD', '2021-12-21 16:01:01', '2021-12-20 23:57:31', 'Angmassalik', NULL, 'ZV53', 16, 'Kabri Dar', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'YBAM', '2021-12-22 07:25:41', '2021-12-20 20:39:16', 'Angelholm', NULL, 'GJ68', 17, 'Seisia', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'KABQ', '2021-12-22 12:23:17', '2021-12-20 21:01:01', 'Laplume', NULL, 'AJ76', 18, 'Albuquerque', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'KABR', '2021-12-22 04:07:22', '2021-12-20 22:43:53', 'Agadir', NULL, 'VT72', 19, 'Aberdeen', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'HEBL', '2021-12-21 18:56:07', '2021-12-21 12:49:25', 'Alta Floresta', NULL, 'KY26', 20, 'Abu Simbel', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'OEBA', '2021-12-21 20:07:18', '2021-12-21 08:12:01', 'San Rafael', NULL, 'LB51', 21, 'Al Aqiq', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'DNAA', '2021-12-22 13:37:52', '2021-12-20 22:25:39', 'Akureyri', NULL, 'QM74', 22, 'Gwagwa', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'YMAY', '2021-12-21 15:32:15', '2021-12-20 21:33:15', 'Alexandria', NULL, 'GK02', 23, 'Albury', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'KABY', '2021-12-22 05:41:34', '2021-12-21 12:48:20', 'Vigra', NULL, 'VT10', 24, 'Albany', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'EGPD', '2021-12-22 04:20:14', '2021-12-21 00:03:24', 'Sochi', NULL, 'HB55', 25, 'Aberdeen', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'MMAA', '2021-12-22 07:17:57', '2021-12-20 23:57:22', 'Buenos Aires', NULL, 'XT47', 26, 'Acapulco', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'DGAA', '2021-12-22 00:21:42', '2021-12-20 17:34:07', 'Abéché', NULL, 'IS70', 27, 'Accra', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'GCRR', '2021-12-21 16:18:30', '2021-12-20 18:19:55', 'San Andrés', NULL, 'QG22', 28, 'San Bartolomé', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'LSZR', '2021-12-22 07:50:17', '2021-12-20 16:14:08', 'St. Andrews', NULL, 'OW78', 29, 'Altenrhein', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'EGJA', '2021-12-22 00:54:15', '2021-12-21 03:07:13', 'Ardabil', NULL, 'BP66', 30, 'St. Peter Port', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'KACK', '2021-12-22 02:47:45', '2021-12-21 08:43:55', 'Kodiak', NULL, 'SW81', 31, 'Nantucket', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'KACP', '2021-12-21 14:46:49', '2021-12-20 14:20:23', 'Adelaide', NULL, 'NP88', 32, 'Sahand', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'KACT', '2021-12-21 20:45:44', '2021-12-21 04:01:06', 'Adak', NULL, 'KZ02', 33, 'Waco', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'KACV', '2021-12-22 02:13:08', '2021-12-21 03:40:58', 'Amman', NULL, 'SI65', 34, 'Mckinleyville', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'KACY', '2021-12-21 16:49:09', '2021-12-21 00:09:51', 'Adiyaman', NULL, 'PQ87', 35, 'Egg Harbor City', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'KACZ', '2021-12-22 04:35:10', '2021-12-20 14:45:39', 'Ash Shaykh Uthman', NULL, 'GU02', 36, 'Zabol', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'LTAF', '2021-12-21 14:48:26', '2021-12-20 15:06:31', 'Addis Ababa', NULL, 'HE04', 37, 'Adana', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'LTBJ', '2021-12-22 00:27:27', '2021-12-20 21:21:32', 'Azmir', NULL, 'EK31', 38, 'Azmir', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'HAAB', '2021-12-22 02:37:45', '2021-12-21 09:22:14', 'Adana', NULL, 'XY05', 39, 'Addis Ababa', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'OYAA', '2021-12-22 01:59:06', '2021-12-20 14:38:16', 'Zabol', NULL, 'MT68', 40, 'Ash Shaykh Uthman', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'LTAG', '2021-12-22 03:48:40', '2021-12-21 05:06:22', 'Egg Harbor City', NULL, 'SZ66', 41, 'Adiyaman', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'OJAM', '2021-12-22 10:43:21', '2021-12-21 01:48:35', 'Mckinleyville', NULL, 'BS26', 42, 'Amman', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-555', 'PADK', '2021-12-21 23:41:49', '2021-12-21 06:29:18', 'Waco', NULL, 'YT24', 43, 'Adak', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'YPAD', '2021-12-21 22:31:47', '2021-12-21 12:40:01', 'Sahand', NULL, 'PG36', 44, 'Adelaide', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-333', 'PADQ', '2021-12-21 18:30:25', '2021-12-21 05:30:16', 'Nantucket', NULL, 'DW81', 45, 'Kodiak', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'OITL', '2021-12-22 08:21:15', '2021-12-20 19:37:48', 'St. Peter Port', NULL, 'KO37', 46, 'Ardabil', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'EGQL', '2021-12-22 09:39:21', '2021-12-21 01:55:03', 'Altenrhein', NULL, 'LU53', 47, 'St. Andrews', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'SKSP', '2021-12-22 09:35:55', '2021-12-20 22:29:34', 'San Bartolomé', NULL, 'AL10', 48, 'San Andrés', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'FTTC', '2021-12-22 13:18:23', '2021-12-20 14:14:53', 'Accra', NULL, 'AN27', 49, 'Abéché', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-444', 'SABE', '2021-12-22 13:15:39', '2021-12-20 23:54:45', 'Acapulco', NULL, 'EH50', 50, 'Buenos Aires', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'URSS', '2021-12-22 00:18:45', '2021-12-20 23:05:44', 'Aberdeen', NULL, 'CX40', 51, 'Sochi', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-555', 'ENAL', '2021-12-22 03:33:00', '2021-12-21 13:37:16', 'Albany', NULL, 'TU88', 52, 'Vigra', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'KAEX', '2021-12-22 09:06:38', '2021-12-21 13:37:33', 'Albury', NULL, 'XX83', 53, 'Alexandria', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'BIAR', '2021-12-22 01:30:18', '2021-12-20 18:58:01', 'Gwagwa', NULL, 'PD51', 54, 'Akureyri', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'SAMR', '2021-12-22 00:30:00', '2021-12-21 10:54:01', 'Al Aqiq', NULL, 'RM70', 55, 'San Rafael', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'SBAT', '2021-12-22 07:58:41', '2021-12-21 01:47:58', 'Abu Simbel', NULL, 'EN00', 56, 'Alta Floresta', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'GMAD', '2021-12-22 06:34:25', '2021-12-20 16:14:47', 'Aberdeen', NULL, 'WV14', 57, 'Agadir', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'LFBA', '2021-12-21 19:11:56', '2021-12-20 20:01:11', 'Albuquerque', NULL, 'QV87', 58, 'Laplume', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'ESTA', '2021-12-22 08:17:42', '2021-12-21 08:55:58', 'Seisia', NULL, 'LW65', 59, 'Angelholm', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'BGAM', '2021-12-22 09:16:54', '2021-12-21 04:15:11', 'Kabri Dar', NULL, 'IT10', 60, 'Angmassalik', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'PAGN', '2021-12-22 11:54:43', '2021-12-20 23:58:04', 'Abidjan', NULL, 'NU80', 61, 'Angoon', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'LEMG', '2021-12-21 20:22:13', '2021-12-21 00:44:01', 'Abilene', NULL, 'YN55', 62, 'Malaga', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'VIAG', '2021-12-22 13:52:58', '2021-12-21 10:14:20', 'Allentown', NULL, 'QF37', 63, 'Agra', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'KAGS', '2021-12-21 17:12:23', '2021-12-20 17:31:26', 'Albacete', NULL, 'EP61', 64, 'Augusta', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'SGES', '2021-12-21 14:06:03', '2021-12-20 22:37:18', 'Abakan', NULL, 'JF77', 65, 'Presidente Franco', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'MMAS', '2021-12-22 13:22:53', '2021-12-20 21:47:31', 'Al Ghaydah', NULL, 'ER67', 66, 'Aguascalientes', 'C');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-666', 'SVAC', '2021-12-21 21:10:19', '2021-12-21 13:25:06', 'Araxá', NULL, 'OP45', 67, 'Acarigua', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'VOAT', '2021-12-22 06:57:35', '2021-12-20 22:39:28', 'Altay', NULL, 'FE88', 68, 'Agatti Island', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'OEAB', '2021-12-22 06:17:57', '2021-12-21 05:54:01', 'Kolind', NULL, 'UO36', 69, 'Hajlah', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-222', 'KAHC', '2021-12-21 17:17:42', '2021-12-20 16:06:04', 'Novorossiysk', NULL, 'RF18', 70, 'Herlong', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-777', 'LIEA', '2021-12-21 14:07:31', '2021-12-21 07:44:52', 'Ayn al Faydah', NULL, 'NX48', 71, 'Alghero', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'GMTA', '2021-12-22 12:10:56', '2021-12-20 19:55:34', 'Mala Mala', NULL, 'DJ26', 72, 'Al Hoceima', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-555', 'KAIA', '2021-12-22 13:30:30', '2021-12-21 09:18:05', 'Norresundby', NULL, 'LI01', 73, 'Alliance', 'A');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-555', 'PAWT', '2021-12-21 14:51:08', '2021-12-20 15:13:08', 'El Tarf', NULL, 'LW52', 74, 'Wainwright', 'B');
insert into "public"."flight" ("airplaneid", "airportid", "arrivingdate", "departdate", "destination", "duration", "flightid", "pilotid", "source", "terminal") values ('B-111', 'NCAI', '2021-12-22 09:20:14', '2021-12-21 08:32:36', 'Anaa', NULL, 'CI32', 75, 'Aitutaki', 'C');
;
