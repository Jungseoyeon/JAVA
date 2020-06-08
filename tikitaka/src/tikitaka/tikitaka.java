package tikitaka;

public class tikitaka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Game{
	//���� �ִ� ����
	
	int[] block_order = new int[9];
	Block[] block =  new Block[9];
	int num_block; //�����ִ� �� ����
	Player player1 = new Player();
	Player player2 = new Player();
	
	void Init() {
		//block_order�� �������� 0~8 ���� �־��ֱ�
		block[0] = new Block("red", block_order[0]);
		block[1] = new Block("orange", block_order[0]);
		block[2] = new Block("yellow", block_order[0]);
		block[7] = new Block("green", block_order[0]);
		block[3] = new Block("sky", block_order[0]);
		block[4] = new Block("blue", block_order[0]);
		block[5] = new Block("purple", block_order[0]);
		block[6] = new Block("pink", block_order[0]);
		block[8] = new Block("gray", block_order[0]);
	}
	
	void gameOver() {
		if(player1.num_card == 0 & player2.num_card == 0)
		{
			//���� ����
		}
	}
	
	
}

class Player {
	//������
	
	int num_card;
	int score;
	MissonCard misson = new MissonCard();
	void calculation(Game game, int score) {
		//���� ��� �� ��ȯ
		//�������� �̼�ī���� 1,2,3�� ������� ���ӿ� �����ϴ� 1,2,3�� ������ ��
		//���� ��� 1�� �� �������� ��
		Block temp = new Block();
		for( int i=0 ; i<9 ; i++)
		{
			if(game.block[i].order == 1)
				temp = game.block[i];
				break;
		}
		if(misson.first.color == temp.color)
			this.score += 10;
		
	}
	Player() { this.num_card = 7; this.score = 0; }
	
}

class Block {
	//����
	
	String color = new String();
	int order;
	boolean exist;
	
	Block() {}
	//���� �������� �̰� ��ü ó���� ������ �� �÷��� �־ ���� �����ϱ�
	Block(String color, int order) { this.color = color; this.order = order; this.exist = true;	}
}

class MissonCard {
	Block first;
	Block second;
	Block third;
	
	//�������� �̾Ƽ� �־��ֱ�
}

class ActionCard {
	//7���� �׼�ī��

	int num;
	Block choose_block; //������ �� ��ü
}

class RemoveCard extends ActionCard {
	//������ ��� ������
	
	RemoveCard() { this.num = 2; } //ó���� �����ϴ� ����
	
	void removeCard(Block choose_block) {
		//������ ��� ������, �̶� choose�� game�� ������ �� �־������
		choose_block.exist = false;
		num --; //�ش� ī�� ���� -1
	}
	
	boolean possible() { return true; } //������ �������� Ȯ�� �� ���� //��� �׻� true
	
}

class DownCard extends ActionCard {
	//������ ��� ���������� ������
	
	DownCard() {this.num = 1; }
	
	boolean possible() { return true; } //������ �������� Ȯ�� �� ���� //��� �׻� true
}
class UpOne extends ActionCard {
	//������ ��� ���� 1ĭ �ø���
	
	UpOne() { this.num = 2; }
	
	boolean possible() {
		if(choose_block.order > 0)
		//������ �������� Ȯ�� �� ����
			return true;
		else return false;
	}
}
class UpTwo extends ActionCard {
	//������ ��� ���� 2ĭ �ø���
	
	UpTwo() { this.num = 1; }
	
	boolean possible() {
		if(choose_block.order > 1)
		//������ �������� Ȯ�� �� ����
			return true;
		else return false;
	}
}
class UpThree extends ActionCard {
	//������ ��� ���� 3ĭ �ø���
	
	UpThree() { this.num = 1; }
	
	boolean possible() {
		if(choose_block.order > 2)
		//������ �������� Ȯ�� �� ����
			return true;
		else return false;
	}
}

