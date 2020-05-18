using System;
using System.Collections.Generic;
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

namespace Exam_3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    /// 
/*    When the user presses the Save menu item it should save all Player data to a file using a
StreamWriter(you can hardcode the name of the file). Exit should close the application.About
should show the developer name(that is your name). */
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.Title = "Exam 3 - Mufrat Karim Aritra";
        }

        private void exitMenu_Click(object sender, RoutedEventArgs e)
        {
            Close();

        }

        private void saveMenu_Click(object sender, RoutedEventArgs e)
        {
            StreamWriter sw = new StreamWriter("Players.txt");


        }

        private void aboutMenu_Click(object sender, RoutedEventArgs e)
        {
            string name = "Mufrat Karim Aritra";
            string title = "Developer Information";
            MessageBox.Show(name, title);
        }

        private void mainWindow_Loaded(object sender, RoutedEventArgs e)
        {


            Player p1 = new Player();
            p1.Name = "Rose";
            p1.Score = 20;

            Player p2 = new Player();
            p2.Name = "Mateo";
            p2.Score = 15;

            tScoreTextBox.Text = Convert.ToString(p1.Score + p2.Score);

            listViewScores.Items.Add(p1);
            listViewScores.Items.Add(p2);


            sNameTextBox.IsReadOnly = true;
            sScoreTextBox.IsReadOnly = true;
            tScoreTextBox.IsReadOnly = true;


        }

        private void listViewScores_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

            Player p = (Player)e.AddedItems[0];

            sNameTextBox.Text = p.Name;
            sScoreTextBox.Text = Convert.ToString(p.Score);

        }

        private void addButton_Click(object sender, RoutedEventArgs e)
        {
            Player p3 = new Player();
            p3.Name = nameTextBox.Text;
            p3.Score = Convert.ToInt32(scoreTextBox.Text);

            tScoreTextBox.Text = Convert.ToString(Convert.ToInt32(tScoreTextBox.Text) + p3.Score);

            listViewScores.Items.Add(p3);

            nameTextBox.Text = "";
            scoreTextBox.Text = "";
        }
    }
}
