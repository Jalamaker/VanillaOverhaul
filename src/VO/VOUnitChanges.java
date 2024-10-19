package VO;

import arc.graphics.Color;
import arc.math.*;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Weapon;

import VO.entities.*;

public class VOUnitChanges {
    public static void load(){

        Effect hitLaserBoltGreen = new MultiEffect(new WrapEffect(Fx.shootSmallColor, Pal.heal), new WrapEffect(Fx.shootSmallColor, Pal.heal, 90), new WrapEffect(Fx.shootSmallColor, Pal.heal, 180), new WrapEffect(Fx.shootSmallColor, Pal.heal, 270), Fx.hitLaser);

        UnitTypes.alpha.trailLength = 40;
        UnitTypes.beta.trailLength = 50;
        UnitTypes.gamma.trailLength = 60;
        UnitTypes.incite.trailLength = 30;
        UnitTypes.emanate.trailLength = 35;
        UnitTypes.mono.trailLength = 10;
        UnitTypes.poly.trailLength = 10;
        UnitTypes.mega.trailLength = 10;
        UnitTypes.quad.trailLength = 30;

        UnitTypes.alpha.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.beta.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.gamma.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);

        UnitTypes.dagger.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.mace.weapons.clear();
        UnitTypes.mace.weapons.add(new Weapon("flamethrower"){{
            top = false;
            reload = 5;
            shootY = 2;
            shootY = 5.9f;
            shootX = 0.1f;
            recoil = 0;
            ejectEffect = Fx.none;
            shootSound = Sounds.flame;
            bullet = new VOFlameBulletType(4.2f, 17){{
                lifetime = 13;
                hitSize = 7;
                ammoMultiplier = 3;
                keepVelocity = false;
                hittable = false;
                collidesAir = true;
                pierce = true;
                pierceBuilding = true;
                pierceCap = 2;
                status = StatusEffects.burning;
                statusDuration = 60 * 4;
                particleAmount = 20;
                particleSizeScl = 1.6f;
                particleSpread = 10f;
                smokeColors = new Color[]{Pal.darkFlame, Color.darkGray, Color.gray};
                colors = new Color[]{Color.white, Color.valueOf("fff4ac"), Pal.lightFlame, Pal.darkFlame, Color.gray};
            }};
        }});
        UnitTypes.scepter.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootBig, Fx.hitBulletSmall);
        UnitTypes.scepter.weapons.get(1).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.scepter.weapons.get(2).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);

        UnitTypes.nova.weapons.get(0).bullet.despawnHit = true;
        UnitTypes.nova.weapons.get(0).bullet.shootEffect = Fx.shootHeal;
        UnitTypes.nova.weapons.get(0).bullet.hitEffect = hitLaserBoltGreen;
        UnitTypes.nova.weapons.get(0).bullet.despawnEffect = Fx.none;

        UnitTypes.atrax.weapons.get(0).shootY = 5.5f;
        UnitTypes.atrax.weapons.get(0).bullet.trailWidth = 3.1f;
        UnitTypes.atrax.weapons.get(0).bullet.trailLength = 4;
        UnitTypes.arkyid.weapons.get(3).bullet.hitEffect = new MultiEffect(Fx.sapExplosion, new ParticleEffect(){{
            lifetime = 90;
            particles = 7;
            length = 60;
            sizeFrom = 7;
            sizeTo = 0;
            colorFrom = Pal.sap.cpy().a(0.5f);
            colorTo = Pal.sap.cpy().a(0.3f);
            interp = Interp.pow5Out;
            sizeInterp = Interp.pow3In;
        }},
        new ParticleEffect(){{
            lifetime = 110;
            particles = 7;
            length = 60;
            sizeFrom = 12;
            sizeTo = 0;
            colorFrom = Pal.sap.cpy().a(0.5f);
            colorTo = Pal.sap.cpy().a(0.3f);
            interp = Interp.pow5Out;
            sizeInterp = Interp.pow3In;
        }});

        UnitTypes.flare.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.zenith.weapons.get(0).shoot = new ShootAlternate(2){{shots = 2;}};
        UnitTypes.zenith.weapons.get(0).bullet.trailWidth = 2.4f;
        UnitTypes.zenith.weapons.get(0).bullet.trailLength = 3;
        UnitTypes.antumbra.weapons.get(2).bullet.hitEffect = new MultiEffect(Fx.shootBig, Fx.hitBulletSmall);
        UnitTypes.antumbra.weapons.get(0).bullet.trailWidth = 2.4f;
        UnitTypes.antumbra.weapons.get(1).bullet.trailWidth = 2.4f;
        UnitTypes.antumbra.weapons.get(0).bullet.trailLength = 3;
        UnitTypes.antumbra.weapons.get(1).bullet.trailLength = 3;

        UnitTypes.poly.weapons.get(0).bullet.despawnHit = true;
        UnitTypes.poly.weapons.get(0).bullet.hitEffect = hitLaserBoltGreen;
        UnitTypes.poly.weapons.get(0).bullet.despawnEffect = Fx.none;
        UnitTypes.poly.weapons.get(0).bullet.trailWidth = 2;
        UnitTypes.poly.weapons.get(0).bullet.trailLength = 4;
        UnitTypes.mega.weapons.get(0).bullet.despawnHit = true;
        UnitTypes.mega.weapons.get(0).bullet.shootEffect = Fx.shootHeal;
        UnitTypes.mega.weapons.get(0).bullet.hitEffect = hitLaserBoltGreen;
        UnitTypes.mega.weapons.get(0).bullet.despawnEffect = Fx.none;
        UnitTypes.mega.weapons.get(1).bullet.despawnHit = true;
        UnitTypes.mega.weapons.get(1).bullet.shootEffect = Fx.shootHeal;
        UnitTypes.mega.weapons.get(1).bullet.hitEffect = hitLaserBoltGreen;
        UnitTypes.mega.weapons.get(1).bullet.despawnEffect = Fx.none;
        UnitTypes.quad.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.massiveExplosion, VOFx.greenBombPlus, 
            new ParticleEffect(){{
                lifetime = 120;
                particles = 1;
                length = 0;
                sizeFrom = 70;
                sizeTo = 70;
                colorFrom = Color.valueOf("98ffa915");
                colorTo = Color.valueOf("98ffa905");
            }}
        );
        UnitTypes.oct.weapons.add(new Weapon(){{
            controllable = aiControllable = display = mirror = false;
            reload = 1;
            shootCone = 360;
            shootOnDeath = true;
            bullet = new ExplosionBulletType(1350, 160){{
                shootEffect = new VOEnergyBoomEffect(){{
                    lifetime = 120;
                    waveSize = 160;
                    waveStroke = 7;
                    length = 190;
                    midLength = 75;
                    width = 9;
                    midWidth = 5;
                    interp = Interp.pow3Out;
                    waveInterp = Interp.pow10Out;
                    color = waveColorFrom = waveColorTo = Pal.heal;
                }};
                smokeEffect = hitEffect = despawnEffect = Fx.none;
                healPercent = 100;
            }};
        }});
        UnitTypes.oct.deathExplosionEffect = Fx.none;

        UnitTypes.risso.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmall, Fx.hitBulletSmall);
        UnitTypes.risso.weapons.get(1).bullet.trailWidth = 2.4f;
        UnitTypes.risso.weapons.get(1).bullet.trailLength = 4;
        UnitTypes.risso.weapons.get(1).bullet.trailColor = Pal.bulletYellowBack;
        UnitTypes.bryde.weapons.get(1).bullet.trailWidth = 2.4f;
        UnitTypes.bryde.weapons.get(1).bullet.trailLength =  4;
        UnitTypes.bryde.weapons.get(1).bullet.trailColor = Pal.bulletYellowBack;
        UnitTypes.sei.weapons.get(1).bullet.hitEffect = new MultiEffect(Fx.shootBig, Fx.hitBulletSmall);
        UnitTypes.sei.weapons.get(0).bullet.trailWidth = 2.4f;
        UnitTypes.sei.weapons.get(0).bullet.trailLength = 3;
        UnitTypes.sei.weapons.get(0).bullet.trailColor = Pal.bulletYellowBack;
        BulletType omuraShot = new RailBulletType(){{
            length = 500;
            damage = 1250;
            pierceDamageFactor = 0.5f;
            shootEffect = Fx.railShoot;
            smokeEffect = Fx.shootBig2;
            pointEffect = new MultiEffect(Fx.railTrail, new ParticleEffect(){{lifetime = 20; particles = 16; length = 50; cone = 10; colorFrom = Color.valueOf("ffffffa15"); colorTo = Color.valueOf("ffffff15"); interp = Interp.pow3Out; sizeInterp = Interp.linear;}});
            pointEffectSpace = 40f;
            hitEffect = Fx.massiveExplosion;
            pierceEffect = Fx.railHit;
        }};
        UnitTypes.omura.weapons.get(0).bullet = omuraShot;

        UnitTypes.retusa.weapons.get(1).bullet.hitEffect = new MultiEffect(new WrapEffect(Fx.shootBigColor, Pal.heal), new WrapEffect(Fx.shootBigColor, Pal.heal, 90), new WrapEffect(Fx.shootBigColor, Pal.heal, 180), new WrapEffect(Fx.shootBigColor, Pal.heal, 270),
            new WaveEffect(){{
                lifetime = 10;
                sizeFrom =  1;
                sizeTo =  32;
                strokeFrom =  2.5f;
                strokeTo =  0;
                colorFrom = Pal.heal;
                colorTo = Pal.heal;
            }}
        );
        UnitTypes.navanax.weapons.get(4).bullet.shootEffect = new MultiEffect(Fx.shootBigColor, Fx.hitEmpSpark);
        UnitTypes.navanax.weapons.get(4).bullet.smokeEffect = new MultiEffect(Fx.shootBigSmoke2, Fx.hitLaser);
        UnitTypes.navanax.weapons.get(4).bullet.lightning = 9;
        UnitTypes.navanax.weapons.get(4).bullet.lightningDamage = 0;
        UnitTypes.navanax.weapons.get(4).bullet.lightningLength = 16;
        UnitTypes.navanax.weapons.get(4).bullet.lightningLengthRand = 0;
        UnitTypes.navanax.weapons.get(4).bullet.lightningColor = Pal.heal;
        UnitTypes.navanax.weapons.get(4).bullet.hitEffect = new MultiEffect(VOFx.navanaxHit, 
            new ParticleEffect(){{
                lifetime = 120;
                particles = 1;
                length = 0;
                sizeFrom = 100;
                sizeTo = 100;
                colorFrom = Color.valueOf("98ffa920");
                colorTo = Color.valueOf("98ffa905");
            }}
        );

        UnitTypes.stell.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
        UnitTypes.precept.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootBigColor, Fx.blastExplosion);
        UnitTypes.precept.weapons.get(0).bullet.fragBullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
        UnitTypes.vanquish.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootBigColor, Fx.hitBulletColor);
        UnitTypes.vanquish.weapons.get(1).bullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
        UnitTypes.vanquish.weapons.get(2).bullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
        UnitTypes.elude.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
        UnitTypes.avert.weapons.get(0).bullet.hitEffect = new MultiEffect(Fx.shootSmallColor, Fx.hitBulletColor);
    }
}