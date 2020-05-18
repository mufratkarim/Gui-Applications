using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Lab_MasterDetail
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            string fileName = "MoviesAll.txt";
            StreamReader sr = new StreamReader(fileName);

            Movie m;

            while (!sr.EndOfStream)
            {
                m = new Movie();
                m.Actors= new List<Actor>();

                Actor a1 = new Actor();
                Actor a2 = new Actor();

                m.Name = sr.ReadLine();
                m.RotTmtScore = Convert.ToInt32(sr.ReadLine());

                m.Review = sr.ReadLine();
                m.picName = sr.ReadLine();


                a1.First = sr.ReadLine();
                a1.Last = sr.ReadLine();
                a2.First = sr.ReadLine();
                a2.Last = sr.ReadLine();

                m.Actors.Add(a1);
                m.Actors.Add(a2);

                listBoxMovie.Items.Add(m);


            }
        }

        private void listBoxMovie_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Movie m = (Movie)e.AddedItems[0];

            textBoxName.Text = m.Name;
            textBoxRts.Text = m.RotTmtScore.ToString();
            textBoxReview.Text = m.Review;

            listviewActors.ItemsSource = m.Actors;

            string fullPathFileName = Environment.CurrentDirectory + "\\" + m.picName;
            BitmapImage bitmap = new BitmapImage();
            bitmap.BeginInit();
            bitmap.UriSource = new Uri(fullPathFileName);
            bitmap.EndInit();
            imagePoster.Source = bitmap;



        }

        private void ClosedMenuItem_Click(object sender, RoutedEventArgs e)
        {
            Close();

        }
    }
}
