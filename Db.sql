USE [master]
GO
/****** Object:  Database [PRG7Project]    Script Date: 22/07/2021 20:30:40 ******/
CREATE DATABASE [PRG7Project]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRG7Project', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\PRG7Project.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PRG7Project_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\PRG7Project_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PRG7Project] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRG7Project].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRG7Project] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRG7Project] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRG7Project] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRG7Project] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRG7Project] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRG7Project] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PRG7Project] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRG7Project] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRG7Project] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRG7Project] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRG7Project] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRG7Project] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRG7Project] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRG7Project] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRG7Project] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PRG7Project] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRG7Project] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRG7Project] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRG7Project] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRG7Project] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRG7Project] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRG7Project] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRG7Project] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PRG7Project] SET  MULTI_USER 
GO
ALTER DATABASE [PRG7Project] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRG7Project] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRG7Project] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRG7Project] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PRG7Project] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PRG7Project] SET QUERY_STORE = OFF
GO
USE [PRG7Project]
GO
/****** Object:  Table [dbo].[BarangPerusahaan]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BarangPerusahaan](
	[IdBarangP] [int] IDENTITY(1,1) NOT NULL,
	[NamaBarangP] [varchar](100) NULL,
	[Keterangan] [varchar](255) NULL,
	[IdJenisBarang] [int] NOT NULL,
	[IdSeksi] [int] NOT NULL,
	[IdVendor] [int] NOT NULL,
	[Stok] [int] NULL,
	[Harga] [int] NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_BarangPerusahaan] PRIMARY KEY CLUSTERED 
(
	[IdBarangP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BarangVendor]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BarangVendor](
	[IdBarangV] [int] IDENTITY(1,1) NOT NULL,
	[NamaBarangV] [varchar](100) NULL,
	[Keterangan] [varchar](255) NULL,
	[IdJenisBarang] [int] NOT NULL,
	[IdVendor] [int] NOT NULL,
	[Harga] [int] NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_BarangVendor] PRIMARY KEY CLUSTERED 
(
	[IdBarangV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetailPeminjaman]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailPeminjaman](
	[IdDetailP] [int] NOT NULL,
	[IdPeminjaman] [varchar](10) NOT NULL,
	[IdBarangP] [int] NOT NULL,
	[Kuantitas] [int] NULL,
	[HargaBarang] [int] NULL,
	[KondisiBarang] [int] NULL,
	[Keterangan] [varchar](255) NULL,
 CONSTRAINT [PK_DetailPengajuanPembelian] PRIMARY KEY CLUSTERED 
(
	[IdDetailP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetailPengajuanPembelian]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailPengajuanPembelian](
	[IdPengajuan] [int] NOT NULL,
	[IdBarangV] [int] NOT NULL,
	[Kuantitas] [int] NULL,
	[HargaBarang] [int] NULL,
	[IdVendor] [int] NOT NULL,
	[StatusBarang] [varchar](50) NULL,
 CONSTRAINT [PK_DetailPengajuanPembelian_1] PRIMARY KEY CLUSTERED 
(
	[IdPengajuan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JenisBank]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JenisBank](
	[IdJenisBank] [int] IDENTITY(1,1) NOT NULL,
	[NamaBank] [varchar](50) NULL,
	[Keterangan] [varchar](255) NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_JenisBank] PRIMARY KEY CLUSTERED 
(
	[IdJenisBank] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JenisBarang]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JenisBarang](
	[IdJenisBarang] [int] IDENTITY(1,1) NOT NULL,
	[NamaBarang] [varchar](50) NULL,
	[Keterangan] [varchar](225) NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_JenisBarang] PRIMARY KEY CLUSTERED 
(
	[IdJenisBarang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Karyawan]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Karyawan](
	[NPK] [varchar](10) NOT NULL,
	[NamaKaryawan] [varchar](100) NULL,
	[JenisKelamin] [char](1) NULL,
	[TanggalLahir] [date] NULL,
	[Alamat] [varchar](225) NULL,
	[Email] [varchar](100) NULL,
	[NoTelepon] [varchar](13) NULL,
	[IdRole] [int] NOT NULL,
	[IdSeksi] [int] NOT NULL,
	[Password] [varchar](50) NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
	[Foto] [varchar](max) NULL,
 CONSTRAINT [PK_Karyawan] PRIMARY KEY CLUSTERED 
(
	[NPK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KeranjangPeminjaman]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KeranjangPeminjaman](
	[IdKeranjang] [int] IDENTITY(1,1) NOT NULL,
	[IdBarangP] [int] NOT NULL,
	[NPK] [varchar](10) NOT NULL,
	[Qyt] [int] NOT NULL,
 CONSTRAINT [PK_Keranjang] PRIMARY KEY CLUSTERED 
(
	[IdKeranjang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KeranjangPengajuan]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KeranjangPengajuan](
	[IdKeranjang] [int] IDENTITY(1,1) NOT NULL,
	[IdBarangV] [int] NOT NULL,
	[NPK] [varchar](10) NOT NULL,
	[Qyt] [int] NOT NULL,
 CONSTRAINT [PK_KeranjangPengajuan] PRIMARY KEY CLUSTERED 
(
	[IdKeranjang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Peminjaman]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Peminjaman](
	[IdPeminjaman] [varchar](10) NOT NULL,
	[NPK] [varchar](10) NOT NULL,
	[TglPeminjaman] [datetime] NULL,
	[TglPengembalian] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[AcceptedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[Status] [int] NULL,
	[IsLate] [int] NULL,
	[Denda] [int] NULL,
	[StatusDenda] [varchar](50) NULL,
 CONSTRAINT [PK_Peminjaman] PRIMARY KEY CLUSTERED 
(
	[IdPeminjaman] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pengajuan]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pengajuan](
	[IdPengajuan] [varchar](10) NOT NULL,
	[NPK] [varchar](10) NOT NULL,
	[TglPengajuan] [datetime] NULL,
	[TotalHarga] [int] NULL,
	[StatusPengajuan] [int] NOT NULL,
	[SudahDibayar] [int] NULL,
	[StatusFinal] [varchar](50) NULL,
	[LastModifiedTime] [datetime] NULL,
	[ModifiedBy] [varchar](50) NULL,
 CONSTRAINT [PK_Pengajuan] PRIMARY KEY CLUSTERED 
(
	[IdPengajuan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[IdRole] [int] IDENTITY(1,1) NOT NULL,
	[NamaRole] [varchar](50) NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[IdRole] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Seksi]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Seksi](
	[IdSeksi] [int] IDENTITY(1,1) NOT NULL,
	[NamaSeksi] [varchar](50) NULL,
	[Keterangan] [varchar](225) NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_Seksi] PRIMARY KEY CLUSTERED 
(
	[IdSeksi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vendor]    Script Date: 22/07/2021 20:30:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendor](
	[IdVendor] [int] IDENTITY(1,1) NOT NULL,
	[NamaVendor] [varchar](50) NULL,
	[Alamat] [varchar](225) NULL,
	[Email] [varchar](100) NULL,
	[NoTelepon] [varchar](13) NULL,
	[NoRekening] [varchar](50) NULL,
	[IdJenisBank] [int] NOT NULL,
	[CreatedTime] [datetime] NULL,
	[LastModifiedTime] [datetime] NULL,
	[CreatedBy] [varchar](50) NULL,
	[ModifiedBy] [varchar](50) NULL,
	[RowStatus] [int] NULL,
 CONSTRAINT [PK_Vendor] PRIMARY KEY CLUSTERED 
(
	[IdVendor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[BarangPerusahaan] ON 

INSERT [dbo].[BarangPerusahaan] ([IdBarangP], [NamaBarangP], [Keterangan], [IdJenisBarang], [IdSeksi], [IdVendor], [Stok], [Harga], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Printer', N'', 1, 3, 3, 2, 15000000, CAST(N'2021-07-14T19:04:09.733' AS DateTime), CAST(N'2021-07-14T19:24:30.107' AS DateTime), N'yang login', N'Dihapus oleh ...', 1)
SET IDENTITY_INSERT [dbo].[BarangPerusahaan] OFF
SET IDENTITY_INSERT [dbo].[BarangVendor] ON 

INSERT [dbo].[BarangVendor] ([IdBarangV], [NamaBarangV], [Keterangan], [IdJenisBarang], [IdVendor], [Harga], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Printer', N'Dispenser Besar', 1, 1, 1500000, CAST(N'2021-07-14T21:01:15.527' AS DateTime), CAST(N'2021-07-19T15:18:39.240' AS DateTime), N'yang login', N'Dirubah oleh ...', 1)
INSERT [dbo].[BarangVendor] ([IdBarangV], [NamaBarangV], [Keterangan], [IdJenisBarang], [IdVendor], [Harga], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'Dispenser', N'Dispenser Besar', 2, 2, 1200000, CAST(N'2021-07-14T21:02:24.247' AS DateTime), CAST(N'2021-07-19T15:18:19.360' AS DateTime), N'yang login', N'Dihapus oleh ...', 1)
SET IDENTITY_INSERT [dbo].[BarangVendor] OFF
SET IDENTITY_INSERT [dbo].[JenisBank] ON 

INSERT [dbo].[JenisBank] ([IdJenisBank], [NamaBank], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Permata', N'Banknya Astra', CAST(N'2021-06-22T23:53:06.117' AS DateTime), CAST(N'2021-06-24T15:10:56.077' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 0)
INSERT [dbo].[JenisBank] ([IdJenisBank], [NamaBank], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'Permata Bank', N'Bank nya punya Astra', CAST(N'2021-06-22T23:57:09.237' AS DateTime), CAST(N'2021-06-23T20:00:13.887' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[JenisBank] ([IdJenisBank], [NamaBank], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (3, N'Mandiri', N'', CAST(N'2021-06-23T19:54:49.140' AS DateTime), CAST(N'2021-06-23T19:59:59.723' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[JenisBank] ([IdJenisBank], [NamaBank], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (4, N'BCA', N'Bank Central Astra', CAST(N'2021-06-24T15:27:08.197' AS DateTime), CAST(N'2021-06-24T15:27:14.753' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
SET IDENTITY_INSERT [dbo].[JenisBank] OFF
SET IDENTITY_INSERT [dbo].[JenisBarang] ON 

INSERT [dbo].[JenisBarang] ([IdJenisBarang], [NamaBarang], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Printer', N'Printernya Polman', CAST(N'2021-06-23T19:45:07.620' AS DateTime), CAST(N'2021-06-23T20:18:10.567' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[JenisBarang] ([IdJenisBarang], [NamaBarang], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'Dispenser', N'Buat minum', CAST(N'2021-06-24T15:27:23.393' AS DateTime), CAST(N'2021-06-24T15:27:39.040' AS DateTime), N'Dibuat oleh ....', N'Dihapus oleh ...', 0)
SET IDENTITY_INSERT [dbo].[JenisBarang] OFF
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00000', N'Anggian Nurcahyo', N'1', CAST(N'2001-10-11' AS Date), N'Sidoarjo', N'anggian.nurcahyo@gmail.com', N'085792769982', 1, 1, N'11102001', NULL, NULL, NULL, NULL, 1, NULL)
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00001', N'Alfadli Bray', N'1', NULL, N'Jakarta', N'fadli@gmail.com', N'0817299111', 1, 1, N'06042000', CAST(N'2021-06-29T20:22:48.600' AS DateTime), CAST(N'2021-06-29T20:22:48.600' AS DateTime), N'Teddy yang login', N'', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00002', N'Adit', N'1', NULL, N'Jakarta', N'aditya@gmail.com', N'0817299121', 1, 1, N'06042000', CAST(N'2021-06-30T11:09:32.183' AS DateTime), CAST(N'2021-06-30T11:09:32.183' AS DateTime), N'yang login', N'', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00004', N'Rafli', N'0', CAST(N'2021-07-20' AS Date), N'Jakarta', N'mayori@gmail.com', N'08172991211', 6, 3, N'06042000', CAST(N'2021-06-30T11:11:31.780' AS DateTime), CAST(N'2021-07-07T18:17:20.813' AS DateTime), N'yang login', N'Yang sekarang login', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00006', N'Albertus', N'0', NULL, N'Bekasi', N'bertus@gmail.com', N'0817299111', 1, 1, N'06042001', CAST(N'2021-06-30T11:12:09.083' AS DateTime), CAST(N'2021-06-30T11:12:09.083' AS DateTime), N'yang login', N'', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00007', N'Lili', N'0', NULL, N'Medan', N'lili@gmail.com', N'0817299111', 3, 1, N'06042001', CAST(N'2021-06-30T11:13:33.233' AS DateTime), CAST(N'2021-06-30T11:13:33.233' AS DateTime), N'yang login', N'', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00008', N'Chori', N'0', NULL, N'Jakarta', N'chorida@gmail.com', N'0817299121', 6, 2, N'06042005', CAST(N'2021-06-30T11:15:45.183' AS DateTime), CAST(N'2021-06-30T11:15:45.183' AS DateTime), N'yang login', N'', 1, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00009', N'Kinan', N'0', NULL, N'Surabaya', N'kinan@gmail.com', N'0183882001', 5, 2, N'06042001', CAST(N'2021-06-30T11:16:42.630' AS DateTime), CAST(N'2021-07-17T23:53:04.767' AS DateTime), N'yang login', N'Dihapus oleh ...', 0, N'')
INSERT [dbo].[Karyawan] ([NPK], [NamaKaryawan], [JenisKelamin], [TanggalLahir], [Alamat], [Email], [NoTelepon], [IdRole], [IdSeksi], [Password], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus], [Foto]) VALUES (N'KRY00010', N'Teddy', N'1', CAST(N'2001-09-10' AS Date), N'Pemalang', N'teddy@gmail.com', N'098183100291', 2, 3, N'06042000', CAST(N'2021-06-30T11:27:08.383' AS DateTime), CAST(N'2021-07-13T21:14:43.997' AS DateTime), N'yang login', N'Dihapus oleh ...', 1, N'')
INSERT [dbo].[Peminjaman] ([IdPeminjaman], [NPK], [TglPeminjaman], [TglPengembalian], [LastModifiedTime], [AcceptedBy], [ModifiedBy], [Status], [IsLate], [Denda], [StatusDenda]) VALUES (N'PNJ00001', N'KRY00000', CAST(N'2021-07-22T19:29:20.387' AS DateTime), NULL, CAST(N'2021-07-22T19:29:20.387' AS DateTime), N'', N'Anggian Nurcahyo', 0, 0, 0, N'Tidak Ada Denda')
INSERT [dbo].[Peminjaman] ([IdPeminjaman], [NPK], [TglPeminjaman], [TglPengembalian], [LastModifiedTime], [AcceptedBy], [ModifiedBy], [Status], [IsLate], [Denda], [StatusDenda]) VALUES (N'PNJ00003', N'KRY00001', CAST(N'2021-07-22T19:43:10.350' AS DateTime), NULL, CAST(N'2021-07-22T19:43:10.350' AS DateTime), N'', N'Alfadli Bray', 0, 0, 0, N'Tidak Ada Denda')
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Karyawan', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'HeadDivision', CAST(N'2021-06-22T21:26:18.180' AS DateTime), CAST(N'2021-06-22T21:26:18.180' AS DateTime), N'Dibuat oleh ....', N'', 1)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (3, N'Admin', CAST(N'2021-06-22T21:55:22.183' AS DateTime), CAST(N'2021-07-17T18:25:54.003' AS DateTime), N'Dibuat oleh ....', N'Dihapus oleh ...', 0)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (4, N'Manager', CAST(N'2021-06-23T00:23:43.087' AS DateTime), CAST(N'2021-06-23T00:23:43.087' AS DateTime), N'Dibuat oleh ....', N'', 1)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (5, N'Sekertari', CAST(N'2021-06-24T14:12:19.973' AS DateTime), CAST(N'2021-06-24T14:12:26.010' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (6, N'KepalaDivisi', CAST(N'2021-06-24T15:24:46.930' AS DateTime), CAST(N'2021-06-24T15:25:08.283' AS DateTime), N'Dibuat oleh ....', N'Dihapus oleh ...', 0)
INSERT [dbo].[Role] ([IdRole], [NamaRole], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (7, N'Bendahara', CAST(N'2021-07-18T21:10:26.010' AS DateTime), CAST(N'2021-07-18T21:10:26.010' AS DateTime), N'Anggian Nurcahyo', N'', 1)
SET IDENTITY_INSERT [dbo].[Role] OFF
SET IDENTITY_INSERT [dbo].[Seksi] ON 

INSERT [dbo].[Seksi] ([IdSeksi], [NamaSeksi], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Humas', N'Hubungi Masyarakat', CAST(N'2021-06-22T22:51:15.977' AS DateTime), CAST(N'2021-06-23T00:00:14.927' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[Seksi] ([IdSeksi], [NamaSeksi], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'CS', N'Customer Services', CAST(N'2021-06-23T00:24:01.207' AS DateTime), CAST(N'2021-06-30T17:58:06.763' AS DateTime), N'Dibuat oleh ....', N'Dirubah oleh ...', 1)
INSERT [dbo].[Seksi] ([IdSeksi], [NamaSeksi], [Keterangan], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (3, N'Kebersihan', N'Bagian Kebersihan', CAST(N'2021-06-24T15:26:11.077' AS DateTime), CAST(N'2021-06-24T15:26:23.453' AS DateTime), N'Dibuat oleh ....', N'Dihapus oleh ...', 0)
SET IDENTITY_INSERT [dbo].[Seksi] OFF
SET IDENTITY_INSERT [dbo].[Vendor] ON 

INSERT [dbo].[Vendor] ([IdVendor], [NamaVendor], [Alamat], [Email], [NoTelepon], [NoRekening], [IdJenisBank], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (1, N'Muju Makmur', N'Jakarta', N'mayori@gmail.com', N'01093081212', N'111302311', 4, CAST(N'2021-07-13T20:37:20.223' AS DateTime), CAST(N'2021-07-13T20:37:20.223' AS DateTime), N'yang login', N'', 1)
INSERT [dbo].[Vendor] ([IdVendor], [NamaVendor], [Alamat], [Email], [NoTelepon], [NoRekening], [IdJenisBank], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (2, N'Baja Steel', N'Tanggerang', N'baja@gmail.com', N'081729910201', N'82810827102', 2, CAST(N'2021-07-13T20:47:17.397' AS DateTime), CAST(N'2021-07-13T20:47:17.397' AS DateTime), N'yang login', N'', 1)
INSERT [dbo].[Vendor] ([IdVendor], [NamaVendor], [Alamat], [Email], [NoTelepon], [NoRekening], [IdJenisBank], [CreatedTime], [LastModifiedTime], [CreatedBy], [ModifiedBy], [RowStatus]) VALUES (3, N'Unilever', N'Jakarta', N'uni@gmail.com', N'0817299121', N'19828121122', 4, CAST(N'2021-07-13T20:48:49.407' AS DateTime), CAST(N'2021-07-17T18:34:10.540' AS DateTime), N'yang login', N'Dihapus oleh ...', 0)
SET IDENTITY_INSERT [dbo].[Vendor] OFF
ALTER TABLE [dbo].[BarangPerusahaan]  WITH CHECK ADD  CONSTRAINT [FK_BarangPerusahaan_JenisBarang] FOREIGN KEY([IdJenisBarang])
REFERENCES [dbo].[JenisBarang] ([IdJenisBarang])
GO
ALTER TABLE [dbo].[BarangPerusahaan] CHECK CONSTRAINT [FK_BarangPerusahaan_JenisBarang]
GO
ALTER TABLE [dbo].[BarangPerusahaan]  WITH CHECK ADD  CONSTRAINT [FK_BarangPerusahaan_Seksi] FOREIGN KEY([IdSeksi])
REFERENCES [dbo].[Seksi] ([IdSeksi])
GO
ALTER TABLE [dbo].[BarangPerusahaan] CHECK CONSTRAINT [FK_BarangPerusahaan_Seksi]
GO
ALTER TABLE [dbo].[BarangPerusahaan]  WITH CHECK ADD  CONSTRAINT [FK_BarangPerusahaan_Vendor] FOREIGN KEY([IdVendor])
REFERENCES [dbo].[Vendor] ([IdVendor])
GO
ALTER TABLE [dbo].[BarangPerusahaan] CHECK CONSTRAINT [FK_BarangPerusahaan_Vendor]
GO
ALTER TABLE [dbo].[BarangVendor]  WITH CHECK ADD  CONSTRAINT [FK_BarangVendor_JenisBarang] FOREIGN KEY([IdJenisBarang])
REFERENCES [dbo].[JenisBarang] ([IdJenisBarang])
GO
ALTER TABLE [dbo].[BarangVendor] CHECK CONSTRAINT [FK_BarangVendor_JenisBarang]
GO
ALTER TABLE [dbo].[BarangVendor]  WITH CHECK ADD  CONSTRAINT [FK_BarangVendor_Vendor] FOREIGN KEY([IdVendor])
REFERENCES [dbo].[Vendor] ([IdVendor])
GO
ALTER TABLE [dbo].[BarangVendor] CHECK CONSTRAINT [FK_BarangVendor_Vendor]
GO
ALTER TABLE [dbo].[DetailPeminjaman]  WITH CHECK ADD  CONSTRAINT [FK_DetailPeminjaman_BarangPerusahaan] FOREIGN KEY([IdBarangP])
REFERENCES [dbo].[BarangPerusahaan] ([IdBarangP])
GO
ALTER TABLE [dbo].[DetailPeminjaman] CHECK CONSTRAINT [FK_DetailPeminjaman_BarangPerusahaan]
GO
ALTER TABLE [dbo].[DetailPengajuanPembelian]  WITH CHECK ADD  CONSTRAINT [FK_DetailPengajuanPembelian_BarangVendor] FOREIGN KEY([IdBarangV])
REFERENCES [dbo].[BarangVendor] ([IdBarangV])
GO
ALTER TABLE [dbo].[DetailPengajuanPembelian] CHECK CONSTRAINT [FK_DetailPengajuanPembelian_BarangVendor]
GO
ALTER TABLE [dbo].[DetailPengajuanPembelian]  WITH CHECK ADD  CONSTRAINT [FK_DetailPengajuanPembelian_Vendor] FOREIGN KEY([IdVendor])
REFERENCES [dbo].[Vendor] ([IdVendor])
GO
ALTER TABLE [dbo].[DetailPengajuanPembelian] CHECK CONSTRAINT [FK_DetailPengajuanPembelian_Vendor]
GO
ALTER TABLE [dbo].[Karyawan]  WITH CHECK ADD  CONSTRAINT [FK_Karyawan_Role] FOREIGN KEY([IdRole])
REFERENCES [dbo].[Role] ([IdRole])
GO
ALTER TABLE [dbo].[Karyawan] CHECK CONSTRAINT [FK_Karyawan_Role]
GO
ALTER TABLE [dbo].[Karyawan]  WITH CHECK ADD  CONSTRAINT [FK_Karyawan_Seksi] FOREIGN KEY([IdSeksi])
REFERENCES [dbo].[Seksi] ([IdSeksi])
GO
ALTER TABLE [dbo].[Karyawan] CHECK CONSTRAINT [FK_Karyawan_Seksi]
GO
ALTER TABLE [dbo].[KeranjangPeminjaman]  WITH CHECK ADD  CONSTRAINT [FK_KeranjangPeminjaman_BarangPerusahaan] FOREIGN KEY([IdBarangP])
REFERENCES [dbo].[BarangPerusahaan] ([IdBarangP])
GO
ALTER TABLE [dbo].[KeranjangPeminjaman] CHECK CONSTRAINT [FK_KeranjangPeminjaman_BarangPerusahaan]
GO
ALTER TABLE [dbo].[KeranjangPengajuan]  WITH CHECK ADD  CONSTRAINT [FK_KeranjangPengajuan_BarangVendor] FOREIGN KEY([IdBarangV])
REFERENCES [dbo].[BarangVendor] ([IdBarangV])
GO
ALTER TABLE [dbo].[KeranjangPengajuan] CHECK CONSTRAINT [FK_KeranjangPengajuan_BarangVendor]
GO
ALTER TABLE [dbo].[Peminjaman]  WITH CHECK ADD  CONSTRAINT [FK_Peminjaman_Karyawan] FOREIGN KEY([NPK])
REFERENCES [dbo].[Karyawan] ([NPK])
GO
ALTER TABLE [dbo].[Peminjaman] CHECK CONSTRAINT [FK_Peminjaman_Karyawan]
GO
ALTER TABLE [dbo].[Pengajuan]  WITH CHECK ADD  CONSTRAINT [FK_Pengajuan_Karyawan] FOREIGN KEY([NPK])
REFERENCES [dbo].[Karyawan] ([NPK])
GO
ALTER TABLE [dbo].[Pengajuan] CHECK CONSTRAINT [FK_Pengajuan_Karyawan]
GO
ALTER TABLE [dbo].[Vendor]  WITH CHECK ADD  CONSTRAINT [FK_Vendor_JenisBank] FOREIGN KEY([IdVendor])
REFERENCES [dbo].[JenisBank] ([IdJenisBank])
GO
ALTER TABLE [dbo].[Vendor] CHECK CONSTRAINT [FK_Vendor_JenisBank]
GO
ALTER TABLE [dbo].[Vendor]  WITH CHECK ADD  CONSTRAINT [FK_Vendor_JenisBank1] FOREIGN KEY([IdJenisBank])
REFERENCES [dbo].[JenisBank] ([IdJenisBank])
GO
ALTER TABLE [dbo].[Vendor] CHECK CONSTRAINT [FK_Vendor_JenisBank1]
GO
USE [master]
GO
ALTER DATABASE [PRG7Project] SET  READ_WRITE 
GO
