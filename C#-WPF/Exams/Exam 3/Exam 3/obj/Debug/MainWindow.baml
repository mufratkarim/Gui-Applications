   M S B A M L   `   `   `  ����A  =Exam 3, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:Exam_3Exam_3  5   	       Exam_3.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   &localclr-namespace:Exam_3     5   	   -   5          �Name$  
mainWindow��5   	    � Title$ 
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� $
��Name��6   $
��Left=�6   $��	37,43,0,0q�6:   $	��Top=�6M   �� 5   
   $��Score��6   $
��Left=�6    $��	39,77,0,0q�6;   $	��Top=�6N   �� 5   
   $��Total Score��6   $
��Left=�6&   $��
37,367,0,0q�6A   $	��Top=�6U   �� 5   
   $��Selected Name��6   $
��Left=�6(   $��475,196,0,0q�6C   $	��Top=�6X   �� 5   
   $��Selected Score��6   $
��Left=�6)   $��477,248,0,0q�6D   $	��Top=�6Y   �� 5   
   -   5         ��Name$ 	addButton��5      $	��Add��6$   $
��Left=�62   $��
37,125,0,0q�6M   $	��Top=�6a   $	��310��6y   $��44��6�   6�   �� 5   
   -   5         ��Name$ nameTextBox��5      $
��Left=�6'   $��23��6B   $��
112,46,0,0q�6N    �� TextWrapping$
 Wrap=�6b   $	��Top=�6v   $	��235��6�   �� 5   
   -   5        $ scoreTextBox��5      $
��Left=�6(   $��23��6C   $��
112,80,0,0q�6O   $
 Wrap=�6c   $	��Top=�6w   $	��235��6�   �� 5   
   -   5        $ sNameTextBox��5      $
��Left=�6(   $��23��6C   $��603,196,0,0q�6O   $
 Wrap=�6d   $	��Top=�6x   $	��120��6�   �� 5   
   -   5        $ sScoreTextBox��5      $
��Left=�6)   $��23��6D   $��603,248,0,0q�6P   $
 Wrap=�6e   $	��Top=�6y   $	��120��6�   �� 5   
   -   5        $ tScoreTextBox��5      $
��Left=�6)   $��23��6D   $��112,371,0,0q�6P   $
 Wrap=�6e   $	��Top=�6y   $	��235��6�   �� 5   
   -   5         ��Name$ listViewScores��5      $
��Left=�6+   $	��153��6F   $��
37,196,0,0q�6S   $	��Top=�6g   $	��310��6    �� View 5      �� 5      .P�5      �� $
��Name��6K    �� DisplayMemberBinding 6%   �� *Name+6K   �� 5      $��Score��6L    6%   �� *Score+6L   5      5      o� 5   
   -	   5         o�Name$ mainMenu��5      $��26��6!   $	��Top=�6-   $��0q�6E   .@�5      m� -
   5        	 m�Name$	 fileMenu��5      $
��File��6)   .@�5      m� -   5        $	 saveMenu��5      $
��Save��6-   6;   �� 5       m� 5!      -   5        $	 exitMenu��5!      $
��Exit��6-   6;   5"      m� 5#      -   5        $	 helpMenu��5#      $
��Help��6)   .@�5$      m� -   5        $	 	aboutMenu��5$      $��About��6.   6=   5%      5&      5(      5)      