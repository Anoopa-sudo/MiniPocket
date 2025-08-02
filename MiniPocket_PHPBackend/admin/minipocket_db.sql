-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2023 at 11:40 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minipocket_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `accommodations`
--

CREATE TABLE `accommodations` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(20) NOT NULL,
  `location` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `type` varchar(20) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` text DEFAULT NULL,
  `available` tinyint(1) NOT NULL DEFAULT 1,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accommodations`
--

INSERT INTO `accommodations` (`id`, `name`, `email`, `location`, `address`, `type`, `price`, `description`, `available`, `image`) VALUES
(1, 'The Car Park', 'help@thecarpark.com', 'Blackburn', '26 Park Road, Blackburn', 'Garage', '700.00', 'A secured parking space with shade for your 4-wheelers', 1, 'https://imageextra.com.au/wp-content/uploads/2021/03/Speed_Hump-scaled-1170x780.jpg'),
(2, 'The Cozy Cottage', 'help@cozycottage.com', 'Blackburn', '23 Park Road, Blackburn', 'House', '1200.00', 'A beautiful and cozy cottage in the heart of Blackburn', 1, 'https://cf.bstatic.com/xdata/images/hotel/max1280x900/240141086.jpg?k=29d6ce5e3067bf224c67332fce36936c1651af8f4b2cab9aac818a348132011a&o=&hp=1'),
(3, 'The Grand Sassi Market', 'help@sassimart.com', 'Preston', '4 Queen Street, Preston', 'Store', '1500.00', 'A luxurious area in the heart of Preston', 1, 'https://lid.zoocdn.com/645/430/1adf46dcb030a232a3e5884549ed197cd1606001.jpg'),
(4, 'The Garage Loft', 'help@jdoegarage.com', 'Lancaster', '12A Bridge Street, Lancaster', 'Garage', '800.00', 'A unique and stylish loft apartment above a garage in the historic city of Lancaster', 1, 'https://images.loopnet.co.uk/i2/1UBMqq8tq1-jNLroJ47tVA_xzBdlXf-aoCCDWhmBUKs/106/industrial-property-for-lease.jpg'),
(5, 'The Countryside Retreat', 'help@cside.com', 'Clitheroe', 'Ribble Valley, Clitheroe', 'House', '2000.00', 'A peaceful and serene countryside retreat in the beautiful Ribble Valley', 1, 'https://eu-assets.simpleview-europe.com/lancashire2017/imageresizer/?image=%2Fdmsimgs%2FBeautiful_timber_lodges_2052214540.jpg&action=ProductDetailProFullWidth'),
(6, 'The Riverside Cottage', 'help@rvrside.com', 'Burnley', '5 Riverside Terrace, Burnley', 'House', '1900.00', 'A charming and cozy cottage by the river in the heart of Burnley', 1, 'https://www.cityshor.com/uploads/article/10_2017/1507302428_13161972_1556057708022175_7909177157290977539_o.jpg'),
(7, 'The Park View Apartment', 'help@parkview.com', 'Blackpool', '20 Queen\'s Promenade, Blackpool', 'Park', '1600.00', 'A modern and comfortable apartment with stunning views of the park in Blackpool', 1, 'https://media.rightmove.co.uk/dir/70k/69364/123120506/69364_100363003309_IMG_00_0000_max_296x197.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `accommodation_applications`
--

CREATE TABLE `accommodation_applications` (
  `id` int(11) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `accommodation_id` int(11) NOT NULL,
  `applied_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accommodation_applications`
--

INSERT INTO `accommodation_applications` (`id`, `user_id`, `accommodation_id`, `applied_at`) VALUES
(1, 'jd1@gmail.com', 6, '2023-04-10 19:26:33'),
(2, 'jd1@gmail.com', 3, '2023-04-10 19:29:56'),
(4, 'jd1@gmail.com', 3, '2023-04-10 19:48:39');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `password`) VALUES
('admin101', 'asd123');

-- --------------------------------------------------------

--
-- Table structure for table `cinemas`
--

CREATE TABLE `cinemas` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `number_of_screens` int(11) NOT NULL,
  `has_parking` tinyint(1) NOT NULL DEFAULT 0,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cinemas`
--

INSERT INTO `cinemas` (`id`, `name`, `location`, `address`, `phone_number`, `number_of_screens`, `has_parking`, `image`) VALUES
(1, 'Vue Cinema Blackburn', 'Blackburn', 'Peel Leisure and Retail Park, Lower Audley St, Blackburn BB1 1DG', '01254 664162', 12, 1, 'https://kidsdayout.info/wp-content/uploads/2022/11/Vue-Cinema-Blackburn.jpg'),
(2, 'Cineworld Bolton', 'Bolton', 'The Valley, 15 Eagley Brook Way, Bolton BL1 8TS', '0330 333 4444', 16, 1, 'https://res.dayoutwiththekids.co.uk/image/upload/w_1600,q_75,c_fill/v1594049133/attractions/c/cineworld-edinburgh-ff7387da/cineworld-785x486.jpg'),
(3, 'Odeon Cinema Rochdale', 'Rochdale', 'Sandbrook Park, Sandbrook Way, Rochdale OL11 1RY', '0333 014 4501', 10, 1, 'https://www.rochdaleonline.co.uk/uploads/f1/news/img/2019123_134155.jpg'),
(4, 'Vue Cinema Manchester Lowry', 'Salford', 'Lowry Outlet, Salford M50 3AG', '0345 308 4620', 11, 1, 'https://www.visitnorthwest.com/wp-content/uploads/2012/07/lowry-outlet-mall-26102015-52.jpg'),
(5, 'Light Cinema New Brighton', 'Wallasey', 'Marine Point, Kings Parade, Wallasey CH45 2HZ', '0151 214 1370', 9, 1, 'https://eu-assets.simpleview-europe.com/marketingliverpool/imageresizer/?image=%2Fdmsimgs%2FLight_Cinema-Starbucks-Morrisons-Marine_Point-New_Brighton_824414523.jpg&action=ProductDetail'),
(6, 'Reel Cinema Burnley', 'Burnley', 'Hollywood Park, Manchester Rd, Burnley BB11 2EG', '01282 808080', 6, 1, 'https://i2-prod.lancs.live/incoming/article21232928.ece/ALTERNATES/s615/0_ReelJPG.jpg'),
(9, 'Cine Studios', 'Bolton', 'The Valley, 15 Eagley Brook Way, Bolton BL1 8TS', '011447788', 4, 0, 'https://static.toiimg.com/photo/msid-96714656/96714656.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `directory`
--

CREATE TABLE `directory` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `service_type` enum('Police','Fire','Ambulance','Hospital','Government','Solicitors') NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `directory`
--

INSERT INTO `directory` (`id`, `name`, `service_type`, `phone_number`, `location`, `address`) VALUES
(1, 'Lancashire Police Department', 'Police', '0123456789', 'Lancashire', '10 Main St, Lancashire'),
(2, 'Lancashire Fire & Rescue', 'Fire', '0123456789', 'Lancashire', '15 Elm Rd, Lancashire'),
(3, 'Lancashire Ambulance Service', 'Ambulance', '0123456789', 'Lancashire', '20 Oak Ave, Lancashire'),
(4, 'Lancashire General Hospital', 'Hospital', '0123456789', 'Lancashire', '25 Maple St, Lancashire'),
(5, 'Lancashire City Hall', 'Government', '0123456789', 'Lancashire', '30 Pine Rd, Lancashire'),
(6, 'Lancashire Legal Services', 'Solicitors', '0123456789', 'Lancashire', '35 Cedar Ave, Lancashire'),
(7, 'Preston Police Department', 'Police', '0123456789', 'Preston', '5 Market St, Preston'),
(8, 'Preston Fire & Rescue', 'Fire', '0123456789', 'Preston', '10 Bridge Rd, Preston'),
(9, 'Preston Ambulance Service', 'Ambulance', '0123456789', 'Preston', '15 High St, Preston'),
(10, 'Preston Hospital', 'Hospital', '0123456789', 'Preston', '20 Church St, Preston'),
(11, 'Preston City Hall', 'Government', '0123456789', 'Preston', '25 Broad St, Preston'),
(12, 'Preston Legal Services', 'Solicitors', '0123456789', 'Preston', '30 Station Rd, Preston'),
(13, 'Blackburn Police Department', 'Police', '0123456789', 'Blackburn', '5 Market St, Blackburn'),
(14, 'Blackburn Fire & Rescue', 'Fire', '0123456789', 'Blackburn', '10 Bridge Rd, Blackburn'),
(15, 'Blackburn Ambulance Service', 'Ambulance', '0123456789', 'Blackburn', '15 High St, Blackburn');

-- --------------------------------------------------------

--
-- Table structure for table `enquiries`
--

CREATE TABLE `enquiries` (
  `id` int(11) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `message` text NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enquiries`
--

INSERT INTO `enquiries` (`id`, `user_id`, `subject`, `message`, `created_at`) VALUES
(1, 'jd1@gmail.com', 'Testing #1', 'I am testing, If this app is working properly or not !!', '2023-04-08 03:12:54'),
(2, 'jd1@gmail.com', 'Need more info', 'Please provide some information about the following: 1. Social Halls near me!2. Game parks', '2023-04-10 19:52:57');

-- --------------------------------------------------------

--
-- Table structure for table `hospitals`
--

CREATE TABLE `hospitals` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `number_of_beds` int(11) NOT NULL,
  `has_emergency` tinyint(1) NOT NULL DEFAULT 0,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospitals`
--

INSERT INTO `hospitals` (`id`, `name`, `location`, `address`, `phone_number`, `number_of_beds`, `has_emergency`, `image`) VALUES
(12, 'Royal Blackburn Hospital', 'Blackburn', 'Haslingden Rd, Blackburn BB2 3HH', '+44 1254 263555', 700, 1, 'https://upload.wikimedia.org/wikipedia/commons/f/f2/The_Royal_Blackburn_Hospital_-_geograph.org.uk_-_2234497.jpg'),
(13, 'Chorley and South Ribble Hospital', 'Chorley', 'Preston Rd, Chorley PR7 1PP', '+44 1257 261222', 200, 0, 'https://copelandgroup.co.uk/wp-content/uploads/2019/04/Chorley-South-Ribble-Hospital-The-Copeland-Group.png'),
(14, 'Royal Lancaster Infirmary', 'Lancaster', 'Ashton Rd, Lancaster LA1 4RP', '+44 1524 65944', 400, 1, 'https://i2-prod.lancs.live/incoming/article19787956.ece/ALTERNATES/s615b/3_Royal-Lancaster-InfirmaryJPG.jpg'),
(15, 'Westmorland General Hospital', 'Kendal', 'Burton Rd, Kendal LA9 7RG', '+44 1539 732288', 150, 0, 'https://ichef.bbci.co.uk/news/624/mcs/media/images/83573000/jpg/_83573558_83573557.jpg'),
(16, 'Fylde Coast Hospital', 'Blackpool', 'St. Annes Rd E, Lytham Saint Annes FY8 3YE', '+44 1253 957500', 100, 1, 'https://images.ctfassets.net/pjshm78m9jt4/355723_header/acf14716bf1b27fee4fceeacd921c6db/importedImage355723_header'),
(17, 'Burnley General Hospital', 'Burnley', 'Casterton Ave, Burnley BB10 2PQ', '+44 1282 425071', 500, 1, 'https://d3d00swyhr67nd.cloudfront.net/w800h800/LAN_ELHT_location_image_2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `job_applications`
--

CREATE TABLE `job_applications` (
  `id` int(11) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `vacancy_id` int(11) NOT NULL,
  `application_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `job_applications`
--

INSERT INTO `job_applications` (`id`, `user_id`, `vacancy_id`, `application_date`) VALUES
(2, 'jd1@gmail.com', 21, '2023-04-08'),
(3, 'jd1@gmail.com', 30, '2023-04-10');

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_bookings`
--

CREATE TABLE `maintenance_bookings` (
  `id` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `maintenance_service_id` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `booked_on` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_services`
--

CREATE TABLE `maintenance_services` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `service_type` enum('Car Repair','Plumbing','Electrical','HVAC','General Repair') NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `poster` text NOT NULL,
  `release_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `poster`, `release_date`) VALUES
(1, 'Avengers: Endgame', 'https://www.iwmbuzz.com/wp-content/uploads/2020/05/10-secret-facts-of-avengers-endgame-you-should-know-920x518.jpg', '2021-04-26'),
(2, 'Joker', 'https://cdn.dribbble.com/users/2202732/screenshots/7059899/joker-movie_artwork_dribbble-min_4x.jpg', '2021-10-04'),
(3, 'The Irishman', 'https://npr.brightspotcdn.com/legacy/sites/wdiy/files/201912/irishmanheader.jpg', '2021-11-27'),
(4, 'Parasite', 'https://i0.wp.com/www.socialnews.xyz/wp-content/uploads/2019/08/14/parasite-movie-HD-posters-and-stills-5.jpg?quality=80&zoom=1&ssl=1', '2021-05-21'),
(5, '1917', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/S/pv-target-images/d7d54474ae0a3dfb169a05d7e62da568d3a3b2e45ec2bcb39f9007ed004096a1._UR1920,1080_.jpg', '2021-12-25'),
(6, 'Once Upon a Time in Hollywood', 'https://i0.wp.com/filmotomy.com/wp-content/uploads/2019/08/OUATIH-2.jpg?fit=1200%2C600&ssl=1', '2021-07-26');

-- --------------------------------------------------------

--
-- Table structure for table `supermarkets`
--

CREATE TABLE `supermarkets` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `open_time` time NOT NULL,
  `close_time` time NOT NULL,
  `offers` text NOT NULL DEFAULT 'None',
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supermarkets`
--

INSERT INTO `supermarkets` (`id`, `name`, `location`, `address`, `phone_number`, `open_time`, `close_time`, `offers`, `image`) VALUES
(1, 'Tesco', 'Lancaster', '11-14 King St, Lancaster LA1 1JN', '0123456789', '08:00:00', '22:00:00', 'Buy one get one free on selected items', 'https://www.lancasterguardian.co.uk/webimg/b25lY21zOmYzMjIzMTNlLTQxNTMtNDFhZC04ZDM5LTIxMWFlY2E3YWYwZjo3YmM3MGUyYS1jZGQ4LTRiNDYtYjhhOS00NTdlZWQwYjZiZDU=.jpg?width=1200&auto=webp&quality=75'),
(2, 'Morrisons', 'Morecambe', 'Central Dr, Morecambe LA4 4EW', '0987654321', '07:00:00', '22:00:00', '50% off on fresh produce every Tuesday', 'https://www.lep.co.uk/webimg/QVNIMTI0ODEzOTQ2.jpg?width=1200&enable=upscale'),
(3, 'Asda', 'Lancaster', 'Ovangle Rd, Lancaster LA1 5JR', '0123456789', '06:00:00', '23:00:00', '2 for 1 on selected breakfast items', 'https://www.lancasterguardian.co.uk/webimg/QVNIMTIyOTk0MzIx.jpg?width=1200&enable=upscale'),
(4, 'Sainsbury\'s', 'Preston', 'Flintoff Way, Preston PR1 6PJ', '0987654321', '07:00:00', '22:00:00', '10% off for NHS workers', 'https://www.lep.co.uk/webimg/b25lY21zOjRiMGMwZmM3LTllZjMtNDljNy1iM2M1LTVhZWRlNjk4Yzk2NToxNTg2MGY1Mi1kYjIzLTRmMzAtYjUyMy1iMjRhMTEwOTY2NDc=.jpg?width=2048&enable=upscalecrop=10:8,smart&width=200&auto=webp&quality=75'),
(5, 'Aldi', 'Blackpool', 'Cherry Tree Rd, Blackpool FY4 4QQ', '0123456789', '08:00:00', '22:00:00', 'Special deals on fresh meat and poultry', 'https://www.blackpoolgazette.co.uk/webimg/b25lY21zOmY0MzQwZTQxLWQ5YTEtNGQ2Ni05MWRmLTQxMDg5YzVmZGZhYTozMDA2YjZiYi00YzY2LTQ4NWEtOTFjNS00N2JiOTdmNTIwZjk=.jpg?width=1200&auto=webp&quality=75&crop=3:2,smart'),
(6, 'Lidl', 'Burnley', 'Westgate, Burnley BB11 1RY', '0987654321', '08:00:00', '21:00:00', 'Selected items on clearance sale', 'https://cdn1.neighbourly.com/companies/5ff885f9d9391a8dcaf00825/images/6001e8d5f570b3abbf466d41.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `location` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `fullname`, `phone`, `location`, `password`) VALUES
('billyj@mail.com', 'Billy Jones', '4455887711', 'London', 'qweqwe'),
('jd1@gmail.com', 'John Doe', '1231231230', 'London', 'asdasd'),
('kel1@gmail.com', 'Kelly Cox', '0123456789', 'Brighton', 'asdqwe123'),
('royk1@gmail.com', 'Roy Kene', '1452145214', 'Manchester', '123asd');

-- --------------------------------------------------------

--
-- Table structure for table `vacancies`
--

CREATE TABLE `vacancies` (
  `id` int(11) NOT NULL,
  `job_post` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `salary` varchar(20) DEFAULT NULL,
  `description` text NOT NULL,
  `company_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vacancies`
--

INSERT INTO `vacancies` (`id`, `job_post`, `company_name`, `location`, `salary`, `description`, `company_email`) VALUES
(21, 'Web Developer', 'ABC Corp', 'Lancashire', '40000-50000', 'We are seeking a talented Web Developer to join our dynamic team. Must have experience with HTML, CSS, JavaScript, and PHP.', 'help@abccorp.com'),
(22, 'Software Engineer', 'XYZ Inc', 'Blackburn', '50000-55000', 'We are looking for a skilled Software Engineer to join our growing team. Must have strong programming skills in Java and experience with Agile methodologies.', 'hr@xyzinc.com'),
(23, 'Web Developer', 'DEF Solutions', 'Preston', '45000-60000', 'We are seeking a creative and innovative Web Developer to join our team. Must have experience with front-end technologies such as React and AngularJS.', 'support@defsolutions.com'),
(24, 'Data Analyst', 'GHI Corporation', 'Burnley', '55000-70000', 'We are seeking a detail-oriented Data Analyst to join our team. Must have experience with SQL and data visualization tools such as Tableau.', 'help@ghicorp.com'),
(25, 'Marketing Manager', 'ABC Corp', 'Lancashire', '60000-80000', 'We are seeking an experienced Marketing Manager to lead our marketing team. Must have a strong understanding of digital marketing strategies and techniques.', 'hr@abccorp.com'),
(26, 'Sales Executive', 'LMN Enterprises', 'Preston', '35000-50000', 'We are seeking a highly motivated Sales Executive to join our team. Must have excellent communication skills and a proven track record of meeting sales targets.', 'help@lmnenterprises.com'),
(27, 'Web Developer', 'ABC Corp', 'Lancashire', '40000-50000', 'We are seeking a talented Web Developer to join our dynamic team. Must have experience with HTML, CSS, JavaScript, and PHP.', 'help@abccorp.com'),
(28, 'Business Analyst', 'PQR Industries', 'Blackburn', '48000-60000', 'We are seeking a highly analytical and detail-oriented Business Analyst to join our team. Must have experience with requirements gathering and documentation.', 'hr@pqrcorp.com'),
(29, 'Software Engineer', 'XYZ Inc', 'Blackburn', '50000-70000', 'We are looking for a skilled Software Engineer to join our growing team. Must have strong programming skills in Java and experience with Agile methodologies.', 'hr@xyzinc.com'),
(30, 'Web Developer', 'DEF Solutions', 'Preston', '45000-80000', 'We are seeking a creative and innovative Web Developer to join our team. Must have experience with front-end technologies such as React and AngularJS.', 'support@defsolutions.com'),
(31, 'Data Analyst', 'GHI Corporation', 'Burnley', '55000-75000', 'We are seeking a detail-oriented Data Analyst to join our team. Must have experience with SQL and data visualization tools such as Tableau.', 'help@ghicorp.com'),
(32, 'Marketing Manager', 'ABC Corp', 'Lancashire', '60000-90000', 'We are seeking an experienced Marketing Manager to lead our marketing team. Must have a strong understanding of digital marketing strategies and techniques.', 'hr@abccorp.com'),
(33, 'Sales Executive', 'LMN Enterprises', 'Preston', '35000-45000', 'We are seeking a highly motivated Sales Executive to join our team. Must have excellent communication skills and a proven track record of meeting sales targets.', 'help@lmnenterprises.com'),
(34, 'Web Developer', 'ABC Corp', 'Lancashire', '40000-60000', 'We are seeking a talented Web Developer to join our dynamic team. Must have experience with HTML, CSS, JavaScript, and PHP.', 'help@abccorp.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accommodations`
--
ALTER TABLE `accommodations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `accommodation_applications`
--
ALTER TABLE `accommodation_applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `accommodation_id` (`accommodation_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `directory`
--
ALTER TABLE `directory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enquiries`
--
ALTER TABLE `enquiries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `enqusfk` (`user_id`);

--
-- Indexes for table `hospitals`
--
ALTER TABLE `hospitals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `job_applications`
--
ALTER TABLE `job_applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `vacancy_id` (`vacancy_id`);

--
-- Indexes for table `maintenance_bookings`
--
ALTER TABLE `maintenance_bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `maintenance_service_id` (`maintenance_service_id`);

--
-- Indexes for table `maintenance_services`
--
ALTER TABLE `maintenance_services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supermarkets`
--
ALTER TABLE `supermarkets`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `vacancies`
--
ALTER TABLE `vacancies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accommodations`
--
ALTER TABLE `accommodations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `accommodation_applications`
--
ALTER TABLE `accommodation_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `directory`
--
ALTER TABLE `directory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `enquiries`
--
ALTER TABLE `enquiries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hospitals`
--
ALTER TABLE `hospitals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `job_applications`
--
ALTER TABLE `job_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `maintenance_bookings`
--
ALTER TABLE `maintenance_bookings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance_services`
--
ALTER TABLE `maintenance_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `supermarkets`
--
ALTER TABLE `supermarkets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `vacancies`
--
ALTER TABLE `vacancies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accommodation_applications`
--
ALTER TABLE `accommodation_applications`
  ADD CONSTRAINT `accommodation_applications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `accommodation_applications_ibfk_2` FOREIGN KEY (`accommodation_id`) REFERENCES `accommodations` (`id`);

--
-- Constraints for table `enquiries`
--
ALTER TABLE `enquiries`
  ADD CONSTRAINT `enqusfk` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job_applications`
--
ALTER TABLE `job_applications`
  ADD CONSTRAINT `job_applications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `job_applications_ibfk_2` FOREIGN KEY (`vacancy_id`) REFERENCES `vacancies` (`id`);

--
-- Constraints for table `maintenance_bookings`
--
ALTER TABLE `maintenance_bookings`
  ADD CONSTRAINT `maintenance_bookings_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `maintenance_bookings_ibfk_2` FOREIGN KEY (`maintenance_service_id`) REFERENCES `maintenance_services` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
