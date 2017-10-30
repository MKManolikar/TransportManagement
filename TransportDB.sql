USE [master]
GO
/****** Object:  Database [Transport]    Script Date: 10/30/2017 5:51:31 PM ******/
CREATE DATABASE [Transport]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Transport', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Transport.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Transport_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Transport_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Transport] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Transport].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Transport] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Transport] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Transport] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Transport] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Transport] SET ARITHABORT OFF 
GO
ALTER DATABASE [Transport] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Transport] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Transport] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Transport] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Transport] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Transport] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Transport] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Transport] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Transport] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Transport] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Transport] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Transport] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Transport] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Transport] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Transport] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Transport] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Transport] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Transport] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Transport] SET  MULTI_USER 
GO
ALTER DATABASE [Transport] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Transport] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Transport] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Transport] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Transport] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Transport]
GO
/****** Object:  Table [dbo].[Cab]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cab](
	[Cab_no] [int] NOT NULL,
	[Driver_id] [int] NULL,
	[Route_no] [int] NULL,
 CONSTRAINT [PK_Cab] PRIMARY KEY CLUSTERED 
(
	[Cab_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CabDetails]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CabDetails](
	[C_id] [int] NOT NULL,
	[Cab_no] [int] NOT NULL,
 CONSTRAINT [PK_Cab_details] PRIMARY KEY CLUSTERED 
(
	[Cab_no] ASC,
	[C_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Commuter]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Commuter](
	[C_id] [int] NOT NULL,
	[C_name] [nchar](45) NULL,
	[C_loc] [int] NOT NULL,
	[C_contact] [int] NULL,
 CONSTRAINT [PK_Commuter] PRIMARY KEY CLUSTERED 
(
	[C_loc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Driver]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Driver](
	[Driver_id] [int] NOT NULL,
	[Driver_name] [varchar](45) NOT NULL,
	[Driver_contact] [int] NOT NULL,
 CONSTRAINT [PK_Driver] PRIMARY KEY CLUSTERED 
(
	[Driver_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Location]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Location](
	[Loc_id] [int] NOT NULL,
	[Loc_name] [varchar](45) NOT NULL,
	[C_loc] [int] NOT NULL,
 CONSTRAINT [PK_Location] PRIMARY KEY CLUSTERED 
(
	[Loc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Route]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Route](
	[Route_no] [int] NOT NULL,
	[Route_name] [nchar](45) NOT NULL,
 CONSTRAINT [PK_Route] PRIMARY KEY CLUSTERED 
(
	[Route_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RouteDetails]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RouteDetails](
	[Route_no] [int] NOT NULL,
	[Loc_id] [int] NOT NULL,
 CONSTRAINT [PK_Route_details] PRIMARY KEY CLUSTERED 
(
	[Route_no] ASC,
	[Loc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 10/30/2017 5:51:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[User_id] [int] IDENTITY(1,1) NOT NULL,
	[User_name] [nchar](45) NOT NULL,
	[User_password] [nchar](45) NOT NULL,
	[User_type] [nchar](10) NOT NULL CONSTRAINT [DF_User_User_type]  DEFAULT (N'commuter'),
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [IX_User] UNIQUE NONCLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Cab]  WITH CHECK ADD  CONSTRAINT [FK_Cab_Driver] FOREIGN KEY([Driver_id])
REFERENCES [dbo].[Driver] ([Driver_id])
GO
ALTER TABLE [dbo].[Cab] CHECK CONSTRAINT [FK_Cab_Driver]
GO
ALTER TABLE [dbo].[Location]  WITH CHECK ADD  CONSTRAINT [FK_Location_Location] FOREIGN KEY([C_loc])
REFERENCES [dbo].[Commuter] ([C_loc])
GO
ALTER TABLE [dbo].[Location] CHECK CONSTRAINT [FK_Location_Location]
GO
USE [master]
GO
ALTER DATABASE [Transport] SET  READ_WRITE 
GO
