-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 28 oct. 2020 à 17:57
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `senforage`
--

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nomFamille` varchar(255) DEFAULT NULL,
  `numTel` varchar(255) DEFAULT NULL,
  `utilisateur_idUser` varchar(255) DEFAULT NULL,
  `village_idVillage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Client`
--

INSERT INTO `Client` (`id`, `adresse`, `nomFamille`, `numTel`, `utilisateur_idUser`, `village_idVillage`) VALUES
(1, 'taiba', 'diop', '123456789', 'MD100', 'TN100'),
(2, 'KHR10', 'DIOP', '987456', NULL, 'KH100'),
(3, 'GY20', 'NDIAYE', '147896325', NULL, 'S100'),
(4, 'Yoff V10', 'NDOYE', '258963147', NULL, 'YF211');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `idUser` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `urlPhoto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUser`, `email`, `nom`, `password`, `prenom`, `urlPhoto`) VALUES
('CM100', 'cheikh@gmail.com', 'MBOW', 'passer', 'Chekh', 'public/img/cheikh.png'),
('MD100', 'mor@gmail.com', 'DIOP', 'passer', 'Mor', 'public/img/mortaiba.png');

-- --------------------------------------------------------

--
-- Structure de la table `Village`
--

CREATE TABLE `Village` (
  `idVillage` varchar(255) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `utilisateur_idUser` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Village`
--

INSERT INTO `Village` (`idVillage`, `nom`, `utilisateur_idUser`) VALUES
('KH100', 'Khar Yalla', 'MD100'),
('S100', 'simplon', 'MD100'),
('TM100', 'Taiba Mbaye', 'MD100'),
('TN100', 'Taiba Ndiaye', 'MD100'),
('YF211', 'Yoff', 'CM100');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg5w12fnbqn6ce59nmjl60o35o` (`utilisateur_idUser`),
  ADD KEY `FKnkkgobuvvmcj20isujcg21vup` (`village_idVillage`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `Village`
--
ALTER TABLE `Village`
  ADD PRIMARY KEY (`idVillage`),
  ADD KEY `FK1mrifaxyxoucaspc23c3uyjbn` (`utilisateur_idUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Client`
--
ALTER TABLE `Client`
  ADD CONSTRAINT `FKg5w12fnbqn6ce59nmjl60o35o` FOREIGN KEY (`utilisateur_idUser`) REFERENCES `Utilisateur` (`idUser`),
  ADD CONSTRAINT `FKnkkgobuvvmcj20isujcg21vup` FOREIGN KEY (`village_idVillage`) REFERENCES `Village` (`idVillage`);

--
-- Contraintes pour la table `Village`
--
ALTER TABLE `Village`
  ADD CONSTRAINT `FK1mrifaxyxoucaspc23c3uyjbn` FOREIGN KEY (`utilisateur_idUser`) REFERENCES `Utilisateur` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
