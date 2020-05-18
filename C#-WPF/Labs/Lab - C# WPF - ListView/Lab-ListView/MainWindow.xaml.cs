using System;
using System.Collections.Generic;
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

namespace Lab_ListView
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

        private void ListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Create instance o business object
            VideoGame vg = new VideoGame();



            // Put data into business object 
            string gameName = textBoxGameName.Text;
            string rating = textBoxRating.Text;
            double price = Convert.ToDouble(textBoxPrice.Text);

            vg.Name = gameName;
            vg.Rating = rating;
            vg.Price = price;

            // Put business object into ListView
            listViewVideoGames.Items.Add(vg);

            // Clear TextBox
/*            textBoxGameName.Text = "";
            textBoxRating.Text = "";
            textBoxPrice.Text = "";*/
        }

    }
}
