   M S B A M L   `   `   `  ����M  IFinal Exam Project, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null7 clr-namespace:Final_Exam_ProjectFinal_Exam_Project  5   	   #    Final_Exam_Project.MainWindow   5   	   W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   2local clr-namespace:Final_Exam_Project     5   	   -   5          �Name$  
mainWindow��5   	    � Title$ 
MainWindow��5   	   $	��450��6   $	��800��6)    � Icon$ icon_3p5_icon.ico��6P   .��5	      � .+�5
   
   �� $��Ingredients��6   $
��Left=�6&   $��	50,39,0,0q�6A   $	��Top=�6T    J� RenderTransformOrigin$ 0.801,1.281&�6l   �� 5   
   -   5         ��Name$ listBoxIngredients��5      $
��Left=�6.   $	��324��6I   $��	50,70,0,0q�6V   $	��Top=�6i   $	��327��6�   6�   o� 5   
   -   5         o�Name$ mainMenu��5      $��21��6!   $��
0,0,-0.4,0q�6-   $	��Top=�6A   .@�5      m� -   5         m�Name$ fileMenu��5      $
��File��6)   .@�5      m� -   5        $ exitMenu��5      $
��Exit��6-   6;   5      m� 5      -   5        $ 
importMenu��5      $��Import��6+   .@�5      m� -   5        $ jsonMenu��5      $��Ingredients from JSON...��6-   6O   5      m� 5      -   5        $ helpMenu��5      $
��Help��6)   .@�5      m� -	   5        $ 	aboutMenu��5      $��About��6.   6=   5      5      �� 5   
   $
��Name��6   $
��Left=�6   $��
402,86,0,0q�6:   $	��Top=�6N   $ 0.331,0.375&�6f   �� 5   
   $��Quantity��6   $
��Left=�6#   $��402,135,0,0q�6>   $	��Top=�6S   �� 5   
   $��Unit of Measurement��6   $
��Left=�6.   $��402,186,0,0q�6I   $	��Top=�6^   $ 0.189,0.391&�6v   �� 5   
   -
   5         ��Name$ textBoxName��5      $��23��6'   $��542,89,10,0q�63    �� TextWrapping$
 Wrap=�6H   $	��Top=�6\   	 � ToolTip$ 	 Selected Ingredient's Name��6t   �� 5   
   -   5        $ textBoxQuantity��5      $��23��6+   $��542,138,9,0q�67   $
 Wrap=�6L   $	��Top=�6`   $$	 Selected Ingredient's Quantity��6x   �� 5   
   -   5        $ textBoxUnit��5      $��23��6'   $��542,189,10,0q�63   $
 Wrap=�6I   $	��Top=�6]   $/	 )Selected Ingredient's Unit of Measurement��6u   5      5      