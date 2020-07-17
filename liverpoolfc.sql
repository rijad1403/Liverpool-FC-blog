-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 29, 2017 at 11:42 PM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `liverpoolfc`
--

-- --------------------------------------------------------

--
-- Table structure for table `igrac`
--

CREATE TABLE `igrac` (
  `igracId` int(11) NOT NULL,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `igracTekst` text COLLATE utf8_unicode_ci NOT NULL,
  `igracSlika` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pozicija` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `brojDresa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `igrac`
--

INSERT INTO `igrac` (`igracId`, `ime`, `prezime`, `igracTekst`, `igracSlika`, `pozicija`, `brojDresa`) VALUES
(1, 'Simon', 'Mignolet', 'Simon Luc Hildebert Mignolet (born 6 March 1988) is a Belgian professional footballer who plays as a goalkeeper for Premier League club Liverpool and the Belgium national team.\r\n\r\nMignolet started his career with Belgian Second Division side Sint-Truiden in 2004, and spent six years with the club, making 100 senior league appearances and scoring a goal. He moved to Premier League side Sunderland in June 2010[3] for £2 million, spending three years with them and making 101 appearances across all competitions before moving to Liverpool in June 2013 for £9 million.[4]\r\n\r\nMignolet has represented the Belgian national team at every level from the Under-16s upwards. He made his senior debut in 2011, has since earned over 15 caps, and was named in their squad for the 2014 FIFA World Cup.', 'mignolet.jpg', 'Golman', 22),
(2, 'Nathaniel', 'Clyne', 'Nathaniel Edwin Clyne (born 5 April 1991) is an English professional footballer who plays as a right back for Premier League club Liverpool and the England national team.\r\n\r\nHe began his career at Crystal Palace, playing regularly in four Championship seasons, before a move to Southampton in 2012, where he spent three seasons in the Premier League. He joined Liverpool in July 2015 for a fee of £12.5 million.\r\n\r\nFormerly an international at under-19 and under-21 level, Clyne made his senior international debut for England in November 2014. He was selected for UEFA Euro 2016.', 'clyne.jpg', 'Odbrambeni', 2),
(3, 'James', 'Milner', 'James Philip Milner (born 4 January 1986) is an English professional footballer who plays for Premier League club Liverpool. A versatile player, he has been utilised in many different positions such as on the wing, in midfield and most recently at left-back.\r\n\r\nMilner\'s talent in football, cricket, and long-distance running was recognised at a very young age. He represented his school in these sports and played football for amateur teams from Rawdon and Horsforth. He supported Leeds United from a young age and was a season ticket holder at the club. In 1996, he joined the Leeds United youth academy. He made his debut for the first team in 2002 aged only 16 and gained prominence as the youngest player to score in the Premier League.\r\n\r\nWhile at Leeds United, he spent time on loan at Swindon Town to gain experience as a first-team player. Following his move to Newcastle United, he was loaned to Aston Villa for a season. He went on to make over 100 appearances for Newcastle, before returning to Aston Villa on a permanent transfer in 2008. After playing an influential role in Aston Villa\'s run to the 2010 League Cup Final and being named 2009–10 PFA Young Player of the Year, Milner joined Manchester City for a reported £26m transfer fee in 2010, going on to win the 2011–12 and 2013–14 Premier League titles, 2010–11 FA Cup and 2013–14 League Cup. After five seasons with Manchester City, Milner signed for Liverpool on a free transfer in 2015.\r\n\r\nMilner made a record 46 appearances for the England national under-21 football team, playing at the 2007 and 2009 UEFA European Under-21 Championships. He also played 61 appearances for the full English national team, scoring once against Moldova. He was selected for the 2010 and 2014 FIFA World Cup squads, as well as the 2012 and UEFA Euro 2016 UEFA Euro Championships. Milner retired from international football in 2016.', 'milner.jpg', 'Odbrambeni', 7),
(4, 'Joël', 'Matip', 'Joël Andre Job Matip (born 8 August 1991) is a German-Cameroonian professional footballer who plays as a centre back for Premier League club Liverpool and the Cameroon national team. \r\nBorn in Bochum, Matip began his career with SC Weitmar 45 before joining VfL Bochum in 1997.[4] After three years in VfL Bochum\'s youth teams, Matip was scouted by Schalke 04 in July 2000.[5]\r\n\r\nMatip made his professional debut on 17 October 2009 in a Regionalliga against 1. FC Saarbrücken.[6] He made his Bundesliga debut for Schalke on 7 November 2009 against Bayern Munich, in which he scored the game-tying goal and was subsequently named man of the match.[7][8]\r\n\r\nOn 2 March 2010, Matip signed a three-and-a-half-year contract with Schalke 04.[9]\r\n\r\nIn January 2012, Schalke announced that Matip signed a two-year contract extension running until 30 June 2016.\r\n\r\nOn 23 February 2013, Matip scored both goals as Schalke recorded an important 2–1 victory over Fortuna Düsseldorf, securing the club\'s second win in 12 games.[10]\r\n\r\nOn 1 July 2016, Matip officially became a Liverpool player, taking the shirt number 32, whilst Cameron Brannagan, who previously wore 32 took number 25.\r\n\r\nMatip made his debut for Liverpool on 23 August 2016 against Burton Albion in the League Cup in a 5–0 win for the Reds.[12] He scored his first goal for the club in a 4–2 Premier League win over Crystal Palace at Selhurst Park on 29 October.[13]\r\n\r\n', 'matip.jpg', 'Odbrambeni', 32),
(5, 'Dejan', 'Lovren', 'Dejan Lovren (born 5 July 1989) is a Croatian professional footballer who plays as a centre back for Premier League club Liverpool and the Croatia national team.\r\n\r\nLovren began his career at Dinamo Zagreb before moving to Olympique Lyonnais in January 2010. He spent three-and-a-half seasons with the Ligue 1 team and won the 2012 Coupe de France before he signed for Southampton in 2013. After one season with Southampton, he joined Liverpool for £20 million.\r\n\r\nHe made his international debut for Croatia in 2009 and has gone on to make over 30 appearances and score two goals for his country, as well as being selected for the 2014 FIFA World Cup in Brazil.', 'lovren.jpg', 'Odbrambeni', 6),
(6, 'Jordan', 'Henderson', 'Jordan Brian Henderson (born 17 June 1990) is an English professional footballer who captains Premier League club Liverpool. He also plays for the England national team and is usually deployed as a central midfielder for both club and country.\r\n\r\nHenderson began his career at Sunderland in 2008, with a loan spell at Coventry City in 2009, before moving to Liverpool in 2011. He became captain of Liverpool in 2015 following the departure of Steven Gerrard. In 2010, Henderson won his first cap for England, having previously played for and captained the under-21 team. He has represented the country at UEFA Euro 2012 and the 2014 FIFA World Cup.', 'henderson.jpg', 'Vezni', 14),
(7, 'Adam', 'Lallana', 'Adam David Lallana (born 10 May 1988) is an English professional footballer who plays as an attacking midfielder for Premier League club Liverpool and England.\r\n\r\nLallana began his youth career with Bournemouth before transferring to Southampton in 2000, where he developed in their academy and became a professional in 2006. After a brief loan back to Bournemouth he broke into Southampton\'s first team as they earned two promotions from League One to the Premier League, becoming captain in 2012. After two seasons in the top flight and an international breakthrough, he joined Liverpool for a reported £25 million in July 2014.\r\n\r\nSince his senior international debut in 2013, Lallana has made over 20 appearances for England and represented them at the 2014 FIFA World Cup and the 2016 UEFA European Championship.', 'lallana.jpg', 'Vezni', 20),
(8, 'Philippe', 'Coutinho', 'Philippe Coutinho Correia (born 12 June 1992) is a Brazilian professional footballer who plays as an attacking midfielder and winger for Premier League club Liverpool and the Brazil national team.\r\n\r\nBorn and raised in Rio de Janeiro, Coutinho showed prodigious talent and excelled in Vasco da Gama\'s youth system. He was signed by Italian side Internazionale in 2008 for €4 million and subsequently loaned back to Vasco, where he became a key player. He made his debut for Internazionale in 2010 and was seen as the "future of Inter", but struggled to establish himself in the first team and was loaned to Spanish club Espanyol in 2012.\r\n\r\nIn January 2013, he was signed by English team Liverpool for £8.5 million. He flourished at Anfield; his combination of vision, passing, dribbling and long-range strikes earned him the nickname Little Magician from Liverpool fans and teammates.[3] After he was named in the 2015 PFA Team of the Year, Brazilian legend Pelé tipped Coutinho for a "great future".[4][5]\r\n\r\nCoutinho made his senior debut for Brazil in 2010 at the age of 18. He has since made over 20 appearances and represented the nation at the 2015 Copa América and the Copa América Centenario.', 'coutinho.jpg', 'Vezni', 10),
(9, 'Sadio', 'Mané', 'Sadio Mané (born 10 April 1992) is a Senegalese professional footballer who plays as a winger for Premier League club Liverpool and the Senegal national team.\r\n\r\nHaving begun his career with Metz in France, he transferred to Red Bull Salzburg in 2012. After winning the Austrian Bundesliga and Austrian Cup in 2014, he was signed by Southampton. In 2015, Mané set a new Premier League record for the fastest hat-trick when he scored three times in 176 seconds during a 6–1 win over Aston Villa.[4] He transferred to Liverpool in 2016 for a fee of £34 million, making him the most expensive African player in history at that time.[5][6]\r\n\r\nMané has earned over 40 caps for Senegal since his debut in 2012, and represented the national team at the 2012 Olympics, 2015 Africa Cup of Nations and 2017 Africa Cup of Nations.', 'mane.jpeg', 'Vezni', 19),
(10, 'Mohamed', 'Salah', 'Mohamed Salah Ghaly (born 15 June 1992) is an Egyptian professional footballer, who plays for Liverpool and the Egypt national team as a winger.\r\n\r\nAs well as representing the Egyptian national team since 2011, he also participated in the 2011 FIFA U-20 World Cup and the 2012 Summer Olympics. He won the Swiss Super League in his first season with Basel, and was awarded the CAF Most Promising African Talent of the Year in 2012.[3] In 2013, he was awarded the SAFP Golden Player award for being the best player in the Swiss Super League.', 'salah.jpg', 'Vezni', 11),
(12, 'Daniel', 'Sturridge', 'Daniel Andre Sturridge (born 1 September 1989) is an English professional footballer who plays for Premier League club Liverpool and the England national team. He plays as a striker, but he has also been used as a winger on many occasions. Born in Birmingham, Sturridge spent four years in the Aston Villa academy before moving to Coventry City. He then signed for Manchester City in 2003. He continued his development at City and played in two FA Youth Cup finals. He made his first-team debut in the 2007–08 season, becoming the only player ever to score in the FA Youth Cup, FA Cup and Premier League in the same season. He left City in 2009 and signed for Chelsea, where he was loaned out to Bolton Wanderers for the second half of the 2010–11 season. After a successful spell at Bolton, scoring eight goals in 12 appearances, he returned to Chelsea for the 2011–12 season. He left Chelsea to join Liverpool in January 2013, where he formed the so-called SAS attacking partnership with Luis Suárez, with Liverpool scoring more than 100 league goals in the 2013–14 season with Sturridge scoring 21 — the pair of them having a 1–2 in the goal scoring stats of the league.[3] The following two seasons were curtailed by a myriad of injuries, limiting Sturridge to very few appearances.[4] Sturridge has represented England at all levels. He made 15 appearances and scored four goals for the under-21 team. He made his debut for England against Sweden on 15 November 2011 and was selected for the 2012 Summer Olympics and the 2014 FIFA World Cup.', 'sturridge.jpg', 'Napadač', 15);

-- --------------------------------------------------------

--
-- Table structure for table `komentar`
--

CREATE TABLE `komentar` (
  `komentarId` int(11) NOT NULL,
  `korisnik_korisnikId` int(11) NOT NULL,
  `vijest_vijestId` int(11) NOT NULL,
  `tekst` mediumtext COLLATE utf8_bin,
  `vrijemeDatumkomentara` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `komentar`
--

INSERT INTO `komentar` (`komentarId`, `korisnik_korisnikId`, `vijest_vijestId`, `tekst`, `vrijemeDatumkomentara`) VALUES
(8, 1, 8, 'komentar 1.', '2017-11-28 00:55:50'),
(9, 9, 8, 'komentar 2.', '2017-11-28 00:58:40'),
(10, 9, 9, 'komentar 3.', '2017-11-28 00:58:58'),
(11, 8, 8, 'komentar 3.', '2017-11-28 10:35:08'),
(12, 9, 8, 'komentar novi.', '2017-11-28 14:37:01');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnikId` int(11) NOT NULL,
  `ime` varchar(45) COLLATE utf8_bin NOT NULL,
  `prezime` varchar(45) COLLATE utf8_bin NOT NULL,
  `korisnickoIme` varchar(45) COLLATE utf8_bin NOT NULL,
  `lozinka` varchar(45) COLLATE utf8_bin NOT NULL,
  `email` varchar(45) COLLATE utf8_bin NOT NULL,
  `korisnikSlika` varchar(45) COLLATE utf8_bin NOT NULL,
  `tipKorisnika` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnikId`, `ime`, `prezime`, `korisnickoIme`, `lozinka`, `email`, `korisnikSlika`, `tipKorisnika`) VALUES
(1, 'Rijad', 'Gračanin', 'rijad', 'rijad', 'rijad.gracanin14@gmail.com', 'rijad.jpg', 'Admin'),
(8, 'Mujo', 'Mujić', 'mujo', 'mujo', 'mujo@gmail.com', 'default0.jpg', 'Korisnik'),
(9, 'Suljo', 'Suljić', 'suljo', 'suljo', 'suljo@gmail.com', 'default7.jpg', 'Korisnik'),
(10, 'Hase', 'Hasić', 'hase', 'hase', 'hase@gmail.com', 'default.jpg', 'Korisnik'),
(11, 'Huse', 'Husić', 'huse', 'huse', 'huse@gmail.com', 'default4.jpg', 'Korisnik'),
(12, 'admin', 'admin', 'admin', 'admin', 'admin@gmail.com', 'default5.jpg', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `menadzer`
--

CREATE TABLE `menadzer` (
  `menadzerId` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `menadzerTekst` text NOT NULL,
  `tipMenadzera` varchar(45) NOT NULL,
  `menadzerSlika` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menadzer`
--

INSERT INTO `menadzer` (`menadzerId`, `ime`, `prezime`, `menadzerTekst`, `tipMenadzera`, `menadzerSlika`) VALUES
(1, 'Jürgen', 'Klopp', 'Jürgen Norbert Klopp (born 16 June 1967) is a German football manager and former professional player who is the current manager of Premier League club Liverpool.\r\n\r\nKlopp spent most of his 15-year playing career at Mainz 05, before going on to become their longest-serving manager from 2001 to 2008, during which time they achieved promotion to the Bundesliga. In 2008, Klopp joined Borussia Dortmund, leading them to back-to-back Bundesliga wins in 2011 and 2012, as well as the DFB-Pokal in 2012, the DFL-Supercup in 2013 and 2014, and their second appearance in a UEFA Champions League final in 2013. Klopp won the German Football Manager of the Year in 2011 and 2012, before leaving Dortmund in 2015 having also become their longest-serving manager. He became manager of Liverpool in October 2015.', 'Glavni trener', 'klopp.jpg'),
(3, 'Željko', 'Buvač', 'Željko Buvač (born 13 September 1961) is a Bosnian Serb football manager and former player. He is currently assistant manager of Premier League club Liverpool. Current Liverpool Manager Jürgen Klopp labelled Buvač as "the brain" in his coaching team, while describing himself as "the heart" and the second assistant coach, Peter Krawietz, as "the eye". Buvač has been credited for developing the high-speed attacking style that brought success at Borussia Dortmund.[1]', 'Pomoćni trener', 'buvac.jpg'),
(4, 'Peter', 'Krawietz', 'Peter Krawietz followed Jürgen Klopp to Liverpool in October 2015 to take up a role as the club\'s new second assistant coach.\r\n\r\nThe pair first met at Mainz 05, where Krawietz served as chief scout, and they have worked closely together ever since.\r\n\r\nDespite having never played football professionally, the 43-year-old was a prominent figure at Borussia Dortmund during an era of great success under his compatriot\'s guidance.\r\n\r\nKrawietz\'s expertise in scouting and analysis even earned him the nickname \'The Eye\' from Klopp, and he arrived at the Reds looking to apply that knowledge in the Premier League.\r\n\r\nAn eventful first campaign saw a mixture of highs and lows, but on July 8 Liverpool announced Krawietz, along with Klopp and Zeljko Buvac, had signed a long-term contract extension.', 'Pomoćni trener', 'krawietz.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tekma`
--

CREATE TABLE `tekma` (
  `tekmaRasporedId` int(11) NOT NULL,
  `protivnik` varchar(45) NOT NULL,
  `vrijeme` datetime NOT NULL,
  `stadion` varchar(45) NOT NULL,
  `domaciGosti` varchar(45) NOT NULL,
  `vrstaTakmicenja` varchar(45) NOT NULL,
  `goloviLiverpool` int(11) NOT NULL,
  `goloviProtivnik` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tekma`
--

INSERT INTO `tekma` (`tekmaRasporedId`, `protivnik`, `vrijeme`, `stadion`, `domaciGosti`, `vrstaTakmicenja`, `goloviLiverpool`, `goloviProtivnik`) VALUES
(44, 'Real Madrid', '2017-08-29 00:00:00', 'Anfield', 'domaci', 'Liga prvaka', 4, 2),
(45, 'Man City', '2017-08-31 21:00:00', 'Anfield', 'domaci', 'Engleska Premijer Liga', 0, 0),
(46, 'Bayern Munich', '2017-08-30 19:35:50', 'Alianz Arena', 'neutral', 'Liga prvaka', 2, 1),
(67, 'Arsenal', '2017-12-09 14:05:31', 'Emirates', 'gosti', 'Evropska Liga', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `vijest`
--

CREATE TABLE `vijest` (
  `vijestId` int(11) NOT NULL,
  `naslov` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `tekst` longtext COLLATE utf8mb4_bin NOT NULL,
  `vijestSlika` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `vrijemeDatum` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `vijest`
--

INSERT INTO `vijest` (`vijestId`, `naslov`, `tekst`, `vijestSlika`, `vrijemeDatum`) VALUES
(8, 'Liverpul obara rekord zbog Holanđanina?', '\'Liverpool Echo\' u današnjem izdanju piše da je Viržil Van Dajk ponovo u žiži interesovanja \'Redsa\'.\r\n\r\nPomenuti izvor piše da je Liverpul spreman i da obori klupski rekord kada su transferi u pitanju kako bi se domogao Holanđanina.\r\n\r\nCena sigurno neće biti manja od 60 miliona funti.\r\n\r\nPodsetimo, Liverpul je nedavno vrbovao jednog od najtraženijih štopera današnjice, ali se povukao zbog pretnji tužbom od strane Sautemptona jer je stupio u pregovore sa njihovim igračem mimo pravila.\r\n\r\nInače, Van Dajk nije otišao sa \'Svecima\' na pripreme u Francusku, taj njegov potez se tumači kao bojkot jer nisu hteli da ga prodaju Liverpulu.\r\n\r\nReprezentativac Holandije nije odigrao nijedan takmičarski meč još od januara kada je doživeo povredu. Pod ugovorom sa \'Svecima\' je do 2022. godine, a novi menadžer Pelegrino veruje da će uspeti da mu "ohladi glavu".\r\n\r\nIpak, on i dalje preko svojih zastupnika vrši pritisak na upravu Sotona da ga puste u Liverpul...', '1.jpg', '2017-08-01 15:56:29'),
(9, 'Ako ode Kutinjo, stiže igrač koji ume sve?!', 'Fudbalski klub Liverpul krenuo je u ofanzivu u finišu prelaznog roka.\r\n\r\nKako prenose brojni engleski mediji, fudbaler Nice Žan Mišel Seri ponovo je na meti Liverpula.\r\n\r\nOvaj sjajni fudbaler koga je nedavno Ćavi Ernandes preporučio Barseloni, može da napusti klub za sumu od 40 miliona evra.\r\n\r\nS obzirom na to kako su cene poludele ovog leta, to nije velika suma novca, poređenja radi toliko je Barselona platila da dovede Paulinja iz Kine.\r\n\r\nSeri je centralni vezni fudbaler, poseduje odličnu tehniku i taktičke sposobnosti, pa nije ni čudo što ga zovu "afrički Ćavi".\r\n\r\n"Gledao sam veliki broj utakmica, videa sa njim, pošto ga nisam poznavao i nikada nisam video takav talenat jednog veznog igrača. Kratki pasovi, duga lopta, taktička inteligencija, šut sa distance, karakter, organizacija igre, on može da igra bilo gde u veznom redu. Seri je fantastičan", rekao je Ćavi kada je čuo a svog naslednika iz Afrike.\r\n\r\nSeri bi bio odlično pojačanje za vezni red Liverpula, naročito ukoliko Filipe Kutinjo ode u Barselonu.', '298044-750x410.jpg', '2017-08-14 17:34:13'),
(10, 'Klop nema izbora, dvojica favorita kao zamene za Kutinja, navijači priželjkuju "bombu"!', 'Dobro obavešteni Liverpul Eho danas je doneo priču da je Klopova prva meta Maks Mejer iz Šalkea, koji se i ranije povezivao sa prelaskom na Enfild.\r\n\r\nNemac može da igra na više ofanzivnih pozicija i po tome je sličan Kutinju, ali je jasno da bi morao i da se prilagodi Premijer ligi.\r\n\r\nDrugo ime, ali manje verovatno je Lorenco Insinje, fudbaler Napolija koji je uglavnom dejstvovao kao levo krilo.\r\n\r\nNavijači nisu zadovoljni ovim potencijalnim zamenama, jasno je da to na papiru, po imenima nedovoljno za tim koji želi da se bori za vrh u Premijer ligi.\r\nNe treba zaboraviti da će Liverpul imati preko 150 miliona evra za pojačanja, Klop je i pre potencijalne prodaje Kutinja imao dovoljno novca za Van Dajka i Nabija Keitu, a sada bi mogao još više da napuni kasu.\r\n\r\nNa primer, iako se o tome ne piše toliko, ali jeste krajem prošle sezone, Pjer-Emerik Obamejang koga je Klop doveo i u Borusiju Dortmund, bi verovatno oduševio navijače na Enfildu. U tom slučaju bi Firmino mogao da dobije malo povučeniju ulogu, ali u ovom momentu ne deluje da Klop razmišlja u tom pravcu, a navijači bi voleli da to bude iznenađenje posle Kutinja.\r\n\r\nAko Kutinjo ode, što se očekuje već naredne nedelje, Liverpul će imati baš dosta novca, ne toliko opcija, ali sasvim dovoljno da Klop napravi jednako dobar tim.\r\n\r\nTakođe, ne treba zaboraviti ni da Barselona nudi pojedine igrače u razmenu kao što su Rafinja, Andre Gomeš, koji bi mogli da ojačaju vezni red.\r\n\r\nKlop je sada na velikom testu, u zavisnosti od njegovih poteza posle odlaska Kutinja, navijači bi mogli da znaju kakva ih sezona očekuje već 1. septembra kada se pijaca zatvori.', 'mejer-600506898020161207191358.jpg', '2017-08-14 17:37:11'),
(12, 'Legenda Liverpula: "Treba nam napadač top klase".', 'Čovek koji je odigrao skoro 500 utakmica za Liverpul tokom 70-ih i 80-ih godina prošlog veka, a početkom ovog kratko bio i menadžer, izjavio je za \'Liverpool Echo\' da bi glavna meta \'Redsa\' trebalo da bude Pjer-Emerik Obamejang.\r\n\r\n"Vidim da se i dalej najviše priča o Van Dajku, ali ja mislim da nam više treba napadač.\r\n\r\nObrambene igrače koje imamo treba uigravati, a treba dovesti Obamejanga. On bi trebalo da bude naša prva meta." rekao je Tompson.\r\n\r\nJirgen Klop je trenirao hitronogog Gabonca u Dortmundu, odlično je upoznat sa njegovim kvalitetima, ali je vrlo upitno da li može da ga ubedi da dođe na \'Enfild Roud\'.', 'preuzmi.jpg', '2017-10-09 15:03:49'),
(13, 'U Liverpulu će se dobro ismejati na ovu ponudu Barselone!', 'Svašta se izdešavalo u Barseloni ovog leta, otišao je Nejmar, stigao je Usman Dembele, pored njega Barsa je angažovala i Deulofeua, Semeda i Paulinja, za sada imaju dobre rezultate, ali s obzirom na povredu novajlije iz Dortmunda i slabu formu Luisa Suareza, videćeo dokle će to trajati.\r\n\r\nPoznato je da klub sa "Kamp Noua" nije hteo tu da se zaustavi ovog leta, kada su pojačanja u pitanju, velika želja uprave viceprvaka Španije bio je fudbaler Liverpula Filipe Kutinjo.\r\n\r\nBrazilac je i sam želeo da se preseli u redove ekipe Ernesta Valverdea, ali Liverpul nije hteo ni da čuje.\r\n\r\nOdbili su sve ponude koje je Barselona poslala na njihovu adresu, a  Kutinjo je do kraja prelaznog roka bio van stroja zbog "povrede".\r\n\r\nIsterali su "Redsi" na kraju svoje, Kutinjo je ostao na "Enfildu", a po povratku u prvi tim počeo je i da pruža sjajne partije.\r\n\r\nBarselona je rešila da nastavi poteru za Brazilcem, pa spremaju novu ponudu za njegove usluge, koju će na adresu Liverpula poslati u januaru.\r\n\r\nInteresantno, ponuda je potpuno nova, čak je i niža od poslednje koja je stigla ovog leta na adresu engleskog kluba.\r\n\r\nBarsa će uprkos tome što je Liverpul odbio da proda Kutinja ovog leta i za više od 130 miliona evra, sada ponuditi 80 miliona evra uz bonuse u vrednosti od 30 milona evra.\r\nU Barseloni jednostavni veruju da Kutinjo ne vredi više od toga, iako uprava "Redsa" za usluge bivšeg igrača Intera traži 200 miliona evra.\r\n\r\nKutinjo je ugovorom vezan za Liverpul do 2022. godine, tako da engleski klub ima svu pregovaračku moć, jedina stvar je što Kutinjo želi u Barselonu, ali za sada se mora priznati da se profesionalno poneo, uprkos neproverenim pričama da je sabotirao Liverpul ovog leta, kako blista u poslednje vreme, vezao je i tri gola u isto toliko poslednjih susreta.\r\n\r\nBarsinih 80+30 miliona će nesumjivo biti odbijeni na "Enfildu", ali uprava katalonskog kluba ne odustaje, videćemo da li će im se upornost isplatiti.', 'kutinjoslavi524576020170923201546.png', '2017-10-09 15:06:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `igrac`
--
ALTER TABLE `igrac`
  ADD PRIMARY KEY (`igracId`);

--
-- Indexes for table `komentar`
--
ALTER TABLE `komentar`
  ADD PRIMARY KEY (`komentarId`),
  ADD KEY `fk_korisnik_has_vijest_vijest1_idx` (`vijest_vijestId`),
  ADD KEY `fk_korisnik_has_vijest_korisnik_idx` (`korisnik_korisnikId`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnikId`);

--
-- Indexes for table `menadzer`
--
ALTER TABLE `menadzer`
  ADD PRIMARY KEY (`menadzerId`);

--
-- Indexes for table `tekma`
--
ALTER TABLE `tekma`
  ADD PRIMARY KEY (`tekmaRasporedId`);

--
-- Indexes for table `vijest`
--
ALTER TABLE `vijest`
  ADD PRIMARY KEY (`vijestId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `igrac`
--
ALTER TABLE `igrac`
  MODIFY `igracId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `komentar`
--
ALTER TABLE `komentar`
  MODIFY `komentarId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnikId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `menadzer`
--
ALTER TABLE `menadzer`
  MODIFY `menadzerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tekma`
--
ALTER TABLE `tekma`
  MODIFY `tekmaRasporedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `vijest`
--
ALTER TABLE `vijest`
  MODIFY `vijestId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `komentar`
--
ALTER TABLE `komentar`
  ADD CONSTRAINT `fk_korisnik_has_vijest_korisnik` FOREIGN KEY (`korisnik_korisnikId`) REFERENCES `korisnik` (`korisnikId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_korisnik_has_vijest_vijest1` FOREIGN KEY (`vijest_vijestId`) REFERENCES `vijest` (`vijestId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
