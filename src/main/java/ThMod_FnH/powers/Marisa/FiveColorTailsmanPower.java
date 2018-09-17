package ThMod_FnH.powers.Marisa;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import ThMod_FnH.ThMod;

import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class FiveColorTailsmanPower
    extends AbstractPower {

  public static final String POWER_ID = "BlazeAwayPower";
  private static final PowerStrings powerStrings =
      CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
  public static final String NAME = powerStrings.NAME;
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public FiveColorTailsmanPower(AbstractCreature owner, int amount) {
    this.name = NAME;
    this.ID = POWER_ID;
    this.owner = owner;
    this.amount = amount;
    this.type = AbstractPower.PowerType.BUFF;
    updateDescription();
    this.img = new Texture("img/powers/burst.png");
  }

  @Override
  public void atStartOfTurnPostDraw() {
    AbstractCard c =
        AbstractDungeon.returnTrulyRandomCard(
            AbstractCard.CardType.ATTACK,
            AbstractDungeon.cardRandomRng
        ).makeCopy();
    AbstractDungeon.actionManager.addToBottom(
        new MakeTempCardInHandAction(c, 1)
    );
  }

  public void updateDescription() {
    this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]);
  }

}